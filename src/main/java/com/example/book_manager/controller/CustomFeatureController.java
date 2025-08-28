package com.example.book_manager.controller;

import com.example.book_manager.service.CustomFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomFeatureController {

    @Autowired
    private CustomFeatureService customFeatureService;

    @GetMapping("/custom/feature")
    public String getCustomFeature() {
        return customFeatureService.getFeatureInfo();
    }
}
