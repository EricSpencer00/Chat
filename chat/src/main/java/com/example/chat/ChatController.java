package com.example.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ChatController {
    @GetMapping("/chat")
    public String chat() {
        return "Hello, Chat!";
    }

    @GetMapping("/index") 
    public String index() {
        return "index.html";
    }
}
