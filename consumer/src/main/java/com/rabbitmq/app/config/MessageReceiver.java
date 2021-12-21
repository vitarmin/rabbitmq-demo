package com.rabbitmq.app.config;

import com.rabbitmq.app.model.Customer;
import com.rabbitmq.app.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "#{autoDeletedQueue.name}")
@Slf4j
public class MessageReceiver {

    @Autowired
    EmailService emailService;

    @RabbitHandler
    public void receive(Customer customer) {
        System.out.println(customer);
        log.debug("Send Mail");
        emailService.sendMessageToCustomer(customer);
    }
}
