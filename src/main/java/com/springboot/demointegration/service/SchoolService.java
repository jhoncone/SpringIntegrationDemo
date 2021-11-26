package com.springboot.demointegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class SchoolService {

    @ServiceActivator(inputChannel = "school.channel")
    public void reiceveMessage(Message<?> message) throws MessagingException{
        System.out.println("#########address.channel###########");
        System.out.println(message);
        System.out.println("#############");
        System.out.println(message.getPayload());
    }

}
