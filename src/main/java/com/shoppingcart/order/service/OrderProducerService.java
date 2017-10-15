package com.shoppingcart.order.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.order.model.OrderMaster;

// This class will be writing the orders to a message queue

@Service
public class OrderProducerService implements IOrderProducerService {
	
/*	@Autowired
	private MessageRepository messageRepository;
*/	
	/*@Override
	public User findUserByName(String userName) {
		return userRepository.findUserByName(userName);
	}
	*/
	
	private final RabbitTemplate template;

	@Autowired
	public OrderProducerService(RabbitTemplate template){
		this.template = template;
	}

	
	@Override
	public OrderMaster addOrder(OrderMaster order) {
		System.out.println("\n\n\n\n***** OrderProducerService->addOrder() **** \n\n\n\n");
		template.convertAndSend(order);
		System.out.println("\n\n\n\n***** Order value returned  **** " + order + "\n\n\n\n");
		return order;
	}

	
}