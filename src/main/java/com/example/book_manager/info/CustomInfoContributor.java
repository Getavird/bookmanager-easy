package com.example.book_manager.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 原理：InfoContributor接口允许向/info端点添加自定义信息
 */
@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> details = new HashMap<>();
        details.put("项目名称", "图书管理系统");
        details.put("版本", "1.0.0");
        details.put("作者", "新人练手项目");
        details.put("描述", "这是一个Spring Boot学习项目");

        builder.withDetail("project", details);
    }
}
