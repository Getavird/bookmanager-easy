package com.example.book_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot主入口
 * @SpringBootApplication 包含三个核心注解：
 *  1. @SpringBootConfiguration：标记为配置类
 *  2. @EnableAutoConfiguration：启用自动配置
 *  3. @ComponentScan：自动扫描当前包及子包组件
 */
@SpringBootApplication
public class BookManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookManagerApplication.class, args);
    }
}