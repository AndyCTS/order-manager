# Overview of the service in the current implementation
This service acts as an interface to the shopping cart of a simple online shopping application. The physical manifestation of the cart is implemented on a RabbitMQ. Each of the orders are mapped to a single shopping session and the OrderMaster POJO has a placeholder to physically contain the orders. 

# Salient features developed
1) Service Discovery
2) Solution orchestration using AMQP for data provisioning and consuming.

# Salient features planned and in progress
1) Configuration as a service
2) API Gateway
3) CQRS
4) Solution orchestration using AMQP for event provisioning and consuming.