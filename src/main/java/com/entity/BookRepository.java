package com.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tony.duan on 4/23/17.
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByBookCategoryId(Integer categoryId);

    Book findById(Integer bookId);

    List<Book> findByBookName(String bookName);
}
