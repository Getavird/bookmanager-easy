package com.example.ezbook_adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Spring Boot Admin 服务器应用
 * 原理：@EnableAdminServer 注解启用 Admin 服务器功能
 * 它会自动配置监控端点和管理界面
 */
@SpringBootApplication
@EnableAdminServer
public class EzbookAdminServerApplication { // 类名与文件名一致
	public static void main(String[] args) {
		SpringApplication.run(EzbookAdminServerApplication.class, args);
	}
}