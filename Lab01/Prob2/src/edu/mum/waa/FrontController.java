package edu.mum.waa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.reflections.Reflections;

import edu.mum.waa.annotations.Controller;
import edu.mum.waa.annotations.RequestMapping;

public class FrontController {
	Set<Object> controllers = new HashSet<>();
	
	public FrontController() {
		init();
	}
	
	private void init() {
		Reflections reflections = new Reflections("edu.mum.waa");
		Set<Class<?>> controllersClass = reflections.getTypesAnnotatedWith(Controller.class);
		for (Class<?> controller : controllersClass) {
			try {
				controllers.add(controller.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			System.out.println(controller.getName());
		}
	}
	
	public void processRequest(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		boolean found = false;
		String requestType = httpRequest.getUri().split("\\.")[0];
		for (Object controller: controllers) {
			for (Method method: controller.getClass().getDeclaredMethods()) {
				System.out.println(method.getName());
				RequestMapping mapping = method.getAnnotation(RequestMapping.class);
				if (mapping != null && mapping.value().equals(requestType)) {
					try {
						method.invoke(controller, httpRequest, httpResponse);
						found = true;
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if (!found) {
			httpResponse.setContentType("text/html");
			httpResponse.setMessage("<html><head></head><body>" + requestType + " not found</body></html>");
			httpResponse.setStatusCode(404);
		}
	}
}
