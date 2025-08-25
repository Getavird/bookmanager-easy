package com.example.book_manager.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 数据库类型条件：根据配置决定是否创建Bean
 * 原理：实现Condition接口，在matches方法中定义条件逻辑
 */
public class DatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 从配置文件中获取数据库类型
        String dbType = context.getEnvironment().getProperty("app.database.type", "mysql");
        // 如果数据库类型是mysql，则条件成立
        return "mysql".equalsIgnoreCase(dbType);
    }
}
