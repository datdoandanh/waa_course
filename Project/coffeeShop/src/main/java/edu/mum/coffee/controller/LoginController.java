package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Person;

@Controller
@RequestMapping("/user")
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@ModelAttribute("person") Person person) {
		return "login";
	}
}
