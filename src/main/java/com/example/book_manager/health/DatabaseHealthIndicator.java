package com.example.book_manager.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 原理：HealthIndicator接口允许自定义健康检查逻辑
 * Spring Boot会自动收集所有HealthIndicator的结果
 */
@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    private final DataSource dataSource;

    public DatabaseHealthIndicator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Health health() {
        // 这里可以添加真实的数据库健康检查逻辑
        boolean databaseUp = checkDatabaseConnection();

        if (databaseUp) {
            return Health.up()
                    .withDetail("database", "MySQL")
                    .withDetail("status", "连接正常")
                    .build();
        } else {
            return Health.down()
                    .withDetail("database", "MySQL")
                    .withDetail("error", "无法连接数据库")
                    .build();
        }
    }

    private boolean checkDatabaseConnection() {
        try (Connection conn = dataSource.getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}
