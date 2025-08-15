package com.example.book_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book_manager.model.Book;
import com.example.book_manager.repository.BookRepository;

/**
 * 图书服务层
 * @Service - 表示这是业务逻辑组件
 * 包含核心业务逻辑
 */
@Service
public class BookService {

    // 依赖注入（Spring核心特性）
    @Autowired
    private BookRepository bookRepository;

    /**
     * 添加新书
     * @param book 图书对象
     * @return 保存后的图书对象（包含生成的ID）
     */
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 获取所有图书
     * @return 图书列表
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * 按ID获取图书
     * @param id 图书ID
     * @return 图书对象（如果存在）
     */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /**
     * 按作者查询图书
     * @param author 作者姓名
     * @return 该作者的图书列表
     */
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    /**
     * 更新图书信息
     * @param id 图书ID
     * @param bookDetails 更新的图书详情
     * @return 更新后的图书对象（如果存在）
     */
    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setYear(bookDetails.getYear());
            book.setIsbn(bookDetails.getIsbn());
            return bookRepository.save(book);
        });
    }

    /**
     * 删除图书
     * @param id 图书ID
     */
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}