package edu.mum.waa.controllers;

import java.util.Date;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;
import edu.mum.waa.annotations.Controller;
import edu.mum.waa.annotations.RequestMapping;

@Controller
public class ContactsCotroller {
	private int count = 0;
	@RequestMapping("/contacts")
	public void contacts(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		StringBuilder response = new StringBuilder();
		response.append("<!DOCTYPE html>");
		response.append("<html>");
		response.append("<head>");
		response.append("<title>ContactsCotroller</title>");
		response.append("</head>");
		response.append("<body>");
		response.append("<p>Contacts</p>");
		response.append("<p>" + new Date() + "</p>");
		response.append("<p> Count " + ++count + "</p>");
		response.append("</body>");
		response.append("</html>");

		httpResponse.setStatusCode(200);
		httpResponse.setMessage(response.toString());
	}
}
