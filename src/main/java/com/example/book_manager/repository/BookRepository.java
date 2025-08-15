package com.example.book_manager.repository;
import com.example.book_manager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/**
 * 图书数据访问接口
 * 继承JpaRepository<实体类, 主键类型>获得CRUD能力
 * Spring Data JPA会自动实现接口方法
 * 无需编写实现类
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // 自定义查询方法：按作者查找（方法名遵循Spring Data JPA命名约定）
    List<Book> findByAuthor(String author);
    
    // 自定义查询方法：按出版年份查找
    List<Book> findByYear(Integer year);
    
    // 自定义查询方法：按标题关键词查找
    List<Book> findByTitleContainingIgnoreCase(String keyword);
}