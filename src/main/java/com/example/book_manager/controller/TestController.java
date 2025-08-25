package com.example.book_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // 使用required = false，当Bean不存在时不会报错
    @Autowired(required = false)
    @Qualifier("databaseType")
    private String databaseType;

    @GetMapping("/test/condition")
    public String testCondition() {
        if (databaseType != null) {
            return "Conditional Bean存在: " + databaseType;
        } else {
            return "Conditional Bean不存在，请检查app.database.type配置";
        }
    }
}
