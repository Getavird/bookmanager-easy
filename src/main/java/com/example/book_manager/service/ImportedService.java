package com.example.book_manager.service;

import org.springframework.stereotype.Service;

/**
 * 演示 @Import 直接导入 Bean 类的示例服务
 * 原理：通过 @Import 直接导入的类会被 Spring 容器管理
 */
@Service
public class ImportedService {

    public String getMessage() {
        return "这是通过 @Import 直接导入的 Bean 类";
    }
}
