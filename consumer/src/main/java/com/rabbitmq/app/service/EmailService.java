package com.rabbitmq.app.service;

import com.rabbitmq.app.model.Customer;

public interface EmailService {
    void sendMessageToCustomer(Customer customer);
}
