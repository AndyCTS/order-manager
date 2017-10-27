package com.shoppingcart.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.order.model.*;
import com.shoppingcart.order.service.IOrderProducerService;

@RestController
@RequestMapping("/Order")
public class OrderProducersController {
	
	@Autowired
	IOrderProducerService orderProducerService;
	
	@PostMapping(value="/putOrderToQueue")
	public ResponseEntity<OrderMaster> createOrder(@RequestBody OrderMaster order) {
		ResponseEntity<OrderMaster> responseEntity;
		System.out.println("\n\n\n\n***** End point putOrderToQueue invoked **** \n\n\n\n");
		order = orderProducerService.addOrder(order);
		System.out.println("\n\n\n\n***** Order returned ****" + order + " \n\n\n\n");
		if (order!=null) {
			responseEntity = new ResponseEntity<OrderMaster>(order, HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<OrderMaster>(HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;

	}

}
