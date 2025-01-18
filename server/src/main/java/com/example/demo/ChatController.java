package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") // Client sends messages here
    @SendTo("/topic/messages") // Broadcasts to this topic
    public Message handleMessage(Message message) {
        return message; // Simply returns the message to be broadcasted
    }
}
