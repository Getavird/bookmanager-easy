package com.example.book_manager.model;

import jakarta.persistence.*;

/**
 * 图书实体类
 * @Entity - 表示这是一个JPA实体类，将映射到数据库表
 * 默认表名与类名相同（"book"）
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String author;
    
    @Column(columnDefinition = "INT") // 可选：明确指定为整数类型
    private Integer year;  // 或改为String year
    
    private String isbn;

    // 无参构造器
    public Book() {}

    public Book(String title, String author, Integer year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Integer getYear() {
        return year;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
