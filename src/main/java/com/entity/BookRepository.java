package com.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by tony.duan on 4/23/17.
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByBookCategoryId(Integer categoryId);

    Book findById(Integer bookId);

    @Query(value = "select * from ishare.book b where b.bookName like %:bookName%", nativeQuery = true)
    List<Book> findByBookNameLike(@Param("bookName")String bookName);
}
