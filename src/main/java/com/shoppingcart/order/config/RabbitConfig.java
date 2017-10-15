package com.shoppingcart.order.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private final ConnectionFactory connectionFactory;

    @Autowired
    public RabbitConfig(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public RabbitTemplate template() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory);
        rabbitTemplate.setRoutingKey("spring-boot1");
        // Todo: This queue name should come from a configuration as a service
        // As a further step - we should also be able to create the message queue programmatically
        // consuming this configuration as a service
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        rabbitTemplate.setMessageConverter(new SerializerMessageConverter());
        
        return rabbitTemplate;
    }
}
