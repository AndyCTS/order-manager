package com.shoppingcart.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	//@RequestMapping(value="/create",method={RequestMethod.POST},consumes="{application/json}}")

	public Map<String, Object> createOrder(@RequestBody OrderMaster order) {
		String msg, sts;
		System.out.println("\n\n\n\n***** End point putOrderToQueue invoked **** \n\n\n\n");
		order = orderProducerService.addOrder(order);
		System.out.println("\n\n\n\n***** Order returned ****" + order + " \n\n\n\n");
		Map <String, Object> dataMap = new HashMap<String, Object>();
		
		if (order!=null) {
			msg="Order created successfully";
			sts="1";						
		}
		else {
			msg="Order creation failed";
			sts="0";	
		}
		dataMap.put("message", msg);
		dataMap.put("status", sts);
		dataMap.put("order", order);
		
		return dataMap;

	}
	

	
/*    @RequestMapping(value= "/findUser", method = {RequestMethod.GET})
    public ResponseEntity<User> findUser(@RequestParam("userName") String userName) {
    	System.out.println(" \n\n\n**** Inside findUser 1 ****\n\n\n");
        User user =  userService.findUserByName(userName);
        System.out.println(" \n\n\n**** Inside findUser 2 ****\n\n\n");

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
*/
	
	

	
}
