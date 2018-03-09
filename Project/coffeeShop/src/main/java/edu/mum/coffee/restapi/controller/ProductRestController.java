package edu.mum.coffee.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController()
@RequestMapping("/api/product")
public class ProductRestController {
	
	@Autowired
	private ProductService service;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> create(Product product) {
		return new ResponseEntity<Product>(service.save(product), HttpStatus.OK);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<?> list() {
		return new ResponseEntity<List<Product>>(service.getAllProduct(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		Product product = service.getProduct(id);
		service.delete(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<?> update(Product product) {
		return new ResponseEntity<Product>(service.save(product), HttpStatus.OK);
	}
}
