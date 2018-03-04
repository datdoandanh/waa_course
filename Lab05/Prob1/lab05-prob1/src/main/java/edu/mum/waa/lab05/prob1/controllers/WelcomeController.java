package edu.mum.waa.lab05.prob1.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(value= {"/","/welcome"})
	public String home(Model model) {
		model.addAttribute("username", getPrincipal());
		return "welcome";
	}
	@RequestMapping("/login-error")
	public String loginError() {
		return "login-error";
	}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		}
		return userName;
	}
}
