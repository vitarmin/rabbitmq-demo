package com.rabbitmq.app.service.impl;

import com.rabbitmq.app.model.Customer;
import com.rabbitmq.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendMessageToCustomer(Customer customer) {
        try {
            StringBuilder subject = new StringBuilder("Created User ");
            SimpleMailMessage message = new SimpleMailMessage();

            subject.append(customer.getFirstName()).append(" ");
            subject.append(customer.getLastName());
            System.out.println(subject.toString());

            message.setTo(customer.getEmail());
            message.setSubject(subject.toString());
            message.setText(customer.toString());
            emailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
