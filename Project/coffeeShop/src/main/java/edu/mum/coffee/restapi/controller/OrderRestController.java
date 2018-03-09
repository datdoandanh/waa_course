package edu.mum.coffee.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@RestController()
@RequestMapping("/api/order")
public class OrderRestController {
	
	@Autowired
	private OrderService service;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> create(Order order) {
		return new ResponseEntity<Order>(service.save(order), HttpStatus.OK);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<?> list() {
		return new ResponseEntity<List<Order>>(service.findAll(), HttpStatus.OK);
	}
	
}
