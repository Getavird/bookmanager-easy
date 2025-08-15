package com.example.book_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.book_manager.service.BookService;
import com.example.book_manager.model.Book;
/**
 * REST控制器
 * @RestController - 组合了@Controller和@ResponseBody
 * 处理HTTP请求并返回JSON响应
 */
@RestController
@RequestMapping("/api/books") // 基础路径映射
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 创建图书
     * POST /api/books
     * @param book 图书对象（从请求体获取）
     * @return 创建的图书对象
     */
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    /**
     * 获取所有图书
     * GET /api/books
     * @return 图书列表
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    /**
     * 获取单个图书
     * GET /api/books/{id}
     * @param id 图书ID
     * @return 图书对象（如果存在）
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 更新图书
     * PUT /api/books/{id}
     * @param id 图书ID
     * @param bookDetails 更新的图书详情
     * @return 更新后的图书对象
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> updatedBook = bookService.updateBook(id, bookDetails);
        return updatedBook.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 删除图书
     * DELETE /api/books/{id}
     * @param id 图书ID
     * @return 无内容响应
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 按作者查询图书
     * GET /api/books/search?author={name}
     * @param author 作者姓名
     * @return 该作者的图书列表
     */
    @GetMapping("/search")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
