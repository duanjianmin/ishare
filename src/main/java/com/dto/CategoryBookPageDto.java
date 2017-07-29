package com.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tony.duan on 4/26/17.
 */
public class CategoryBookPageDto {
    private Map<Integer,String> categoryMap = new LinkedHashMap<>();
    private List<BookDto> booksList = new ArrayList<>();
    private String categoryName;
    private Integer categoryId;
    private Integer pageNumber;
    private Integer lastPage;
    private String bookName;

    private String fileServerPrefix;

    public String getFileServerPrefix() {
        return fileServerPrefix;
    }

    public void setFileServerPrefix(String fileServerPrefix) {
        this.fileServerPrefix = fileServerPrefix;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Map<Integer, String> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<Integer, String> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public List<BookDto> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<BookDto> booksList) {
        this.booksList = booksList;
    }
}
