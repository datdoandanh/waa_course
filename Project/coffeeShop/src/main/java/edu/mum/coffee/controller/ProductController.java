package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@RequestMapping(value="/type/{type}", method=RequestMethod.GET)
	public String findByProductType(@PathVariable("type") String type, Model model) {
		ProductType productType = ProductType.valueOf(type.toUpperCase());
		List<Product> products = service.findByProductType(productType);
		model.addAttribute("products", products);
		return "index";
	}
	
}
