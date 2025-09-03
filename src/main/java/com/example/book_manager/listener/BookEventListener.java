package com.example.book_manager.listener;

import com.example.book_manager.event.BookCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 原理：使用@EventListener注解声明事件监听器
 * 方法参数类型决定了监听的事件类型
 */
@Component
public class BookEventListener {

    private static final Logger logger = LoggerFactory.getLogger(BookEventListener.class);

    // 同步事件处理
    @EventListener
    public void handleBookCreatedSync(BookCreatedEvent event) {
        logger.info("同步处理 - 图书已创建: {}", event.getBook().getTitle());
    }

    // 异步事件处理
    @Async
    @EventListener
    public void handleBookCreatedAsync(BookCreatedEvent event) {
        logger.info("异步处理 - 图书已创建: {}", event.getBook().getTitle());
        // 模拟耗时操作
        try {
            Thread.sleep(2000);
            logger.info("异步处理完成: {}", event.getBook().getTitle());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
