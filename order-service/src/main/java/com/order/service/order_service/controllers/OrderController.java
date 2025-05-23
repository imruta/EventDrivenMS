package com.order.service.order_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.order_service.oservice.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	@Autowired
	public OrderService Oservice;
	@PostMapping()
	public ResponseEntity<?> createOrder()
	{
		String msg=Oservice.createOrder();
		return ResponseEntity.ok("order successfully created !@!....controller "+msg);
	}

}
