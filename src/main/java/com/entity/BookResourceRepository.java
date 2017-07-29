package com.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tony.duan on 4/23/17.
 */
public interface BookResourceRepository extends JpaRepository<BookResource,Integer>  {
    List<BookResource> findByBookId(Integer bookId);

}
