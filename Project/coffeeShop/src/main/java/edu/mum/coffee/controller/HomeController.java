package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {

	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model) {
		
		return "redirect:/product/type/breakfast";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
}
