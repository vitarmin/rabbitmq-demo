package com.rabbitmq.app.controller;

import com.rabbitmq.app.service.CustomerService;
import com.rabbitmq.app.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> postCustomer(@RequestBody Customer body) {
        Customer customer = null;
        log.debug("Start");
        try {
            customer = customerService.createCustomer(body);

        } catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
