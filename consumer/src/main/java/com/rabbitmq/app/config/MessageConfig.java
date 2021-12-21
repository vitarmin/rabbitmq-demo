package com.rabbitmq.app.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("customer.topic");
    }

    @Bean
    public Queue autoDeletedQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(TopicExchange topic, Queue autoDeletedQueue) {
        return BindingBuilder.bind(autoDeletedQueue).to(topic).with("email.customer");
    }

    @Bean
    public MessageReceiver receiver() {
        return new MessageReceiver();
    }
}
