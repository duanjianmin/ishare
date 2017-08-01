package com.service;

import com.dto.BookDto;
import com.dto.CategoryBookPageDto;
import com.dto.DashboardDto;

/**
 * Created by tony.duan on 4/22/17.
 */
public interface DashboardService {
    String findTest(String name);

    DashboardDto fetchTopBooks(int topNumberForAllBooks , int topNumberForCategory);

    CategoryBookPageDto fetchCategoryBooks(Integer categoryId,Integer pageNumber);

    BookDto fetchBook(Integer bookId);

    CategoryBookPageDto searchByBookName(String bookName,Integer pageNumber);

    CategoryBookPageDto searchByBookDto(BookDto bookDto,Integer pageNumber);


}
