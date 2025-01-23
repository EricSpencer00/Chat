package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Catch-all route to forward to Angular's index.html
        registry.addViewController("/{spring:[a-zA-Z0-9-_]+}").setViewName("forward:/index.html");
        registry.addViewController("/**").setViewName("forward:/index.html");
    }
}
