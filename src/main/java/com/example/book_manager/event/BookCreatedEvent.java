package com.example.book_manager.event;

import com.example.book_manager.model.Book;
import org.springframework.context.ApplicationEvent;

/**
 * 原理：Spring事件机制基于观察者模式
 * 自定义事件需要继承ApplicationEvent类
 */
public class BookCreatedEvent extends ApplicationEvent {
    private final Book book;

    public BookCreatedEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
