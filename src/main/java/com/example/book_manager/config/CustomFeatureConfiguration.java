package com.example.book_manager.config;

import com.example.book_manager.service.CustomFeatureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFeatureConfiguration {

    @Bean
    public CustomFeatureService customFeatureService() {
        return new CustomFeatureService();
    }
}
