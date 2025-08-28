package com.example.book_manager.service;

import org.springframework.stereotype.Service;

@Service
public class CustomFeatureService {

    public String getFeatureInfo() {
        return "这是通过@EnableCustomFeature注解启用的自定义功能";
    }
}
