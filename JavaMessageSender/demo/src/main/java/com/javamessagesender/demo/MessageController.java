package com.javamessagesender.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    // Queue name has to be configured as destination name
    private static final String QUEUE_NAME = "<DestinationName>";

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages/{message}")
    public String send(@PathVariable String message){
        logger.info("Sending message");
        jmsTemplate.convertAndSend(QUEUE_NAME, message);
        return message;
    }

    @JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) {
        logger.info("Received message: {}", message);
    }
}

