package com.example.book_manager.config;

import com.example.book_manager.condition.DatabaseTypeCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {
    /**
     * 只有当DatabaseTypeCondition条件成立时，才会创建这个Bean
     * 原理：@Conditional注解将条件判断与Bean创建过程解耦
     */
    @Bean
    @Conditional(DatabaseTypeCondition.class)
    public String databaseType() {
        return "MySQL Database";
    }
}
