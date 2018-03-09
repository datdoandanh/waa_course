package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductManagementController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", service.getAllProduct());
		return "/admin/product/index";
	}
	
}
