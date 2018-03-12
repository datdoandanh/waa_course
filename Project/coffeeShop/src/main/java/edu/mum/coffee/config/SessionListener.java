package edu.mum.coffee.config;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Component("sessionListener")
public class SessionListener{

	@Autowired
	PersonService service;
	
	private String name = "Doan Danh Dat";
	
	@Autowired
	HttpSession session;
	
	public Person getPerson() {
		if (session.getAttribute("loggedUser") != null) {
			return (Person) session.getAttribute("loggedUser");
		}
		List<Person> persons = service.findByEmail(getPrincipal());
		if (persons.size() == 1) {
			session.setAttribute("loggedUser", persons.get(0));
			return persons.get(0);
		}
		return new Person();
		
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}


