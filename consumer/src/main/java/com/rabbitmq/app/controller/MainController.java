package com.rabbitmq.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class MainController {

    @PostMapping()
    public ResponseEntity<?> postCustomer() {
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
