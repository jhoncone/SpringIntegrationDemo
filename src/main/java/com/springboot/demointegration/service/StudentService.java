package com.springboot.demointegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @ServiceActivator(inputChannel = "student.channel")
    public void reiceveMessage(Message<?> message) throws MessagingException{
        System.out.println("#########student.channel###########");
        System.out.println(message);
        System.out.println("#############");
        System.out.println(message.getPayload());
    }

    /*
    @ServiceActivator(inputChannel = "integration.student.objectToJson.channel",outputChannel = "integration.student.jsonToObject.channel")
    public Message<?> reiceveMessage(Message<?> message) throws MessagingException{
        System.out.println("##############");
        System.out.println(message);
        System.out.println("###############");
        System.out.println("Object to json - " + message.getPayload());
        return message;
    }

    @ServiceActivator(inputChannel = "integration.student.jsonToObject.fromTransformer.channel")
    public void processJsonToObject(Message<?> message) throws MessagingException{
        MessageChannel replyChannel=(MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        System.out.println("################");
        System.out.println("Json to Object - " +message.getPayload());
        Student student=(Student) message.getPayload();
        Message<?> newMessage= MessageBuilder.withPayload(student.toString()).build();
        replyChannel.send(newMessage);
    }

     */
}
