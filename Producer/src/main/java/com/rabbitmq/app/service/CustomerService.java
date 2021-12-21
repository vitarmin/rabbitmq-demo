package com.rabbitmq.app.service;

import com.rabbitmq.app.config.MessageSender;
import com.rabbitmq.app.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    MessageSender sender;

    public Customer createCustomer(Customer customer) {
//        customer
//        Customer result = customerRepository.save(customer);
        log.debug("Send Message");
        sender.sendEmail(customer);
        log.debug("End Send Message");
        return customer;
    }
}
