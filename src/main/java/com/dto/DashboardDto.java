package com.dto;

import java.util.*;

/**
 * Created by tony.duan on 4/23/17.
 */
public class DashboardDto {

    private Map<Integer,String> categoryMap = new LinkedHashMap<>();
    private List<BookDto> topAllBooksList = new ArrayList<>();
    private Map<Integer,List<BookDto>> categoryBooksMap = new HashMap<>();
    private String fileServerPrefix;

    public String getFileServerPrefix() {
        return fileServerPrefix;
    }

    public void setFileServerPrefix(String fileServerPrefix) {
        this.fileServerPrefix = fileServerPrefix;
    }

    public List<BookDto> getTopAllBooksList() {
        return topAllBooksList;
    }

    public void setTopAllBooksList(List<BookDto> topAllBooksList) {
        this.topAllBooksList = topAllBooksList;
    }

    public Map<Integer, List<BookDto>> getCategoryBooksMap() {
        return categoryBooksMap;
    }

    public void setCategoryBooksMap(Map<Integer, List<BookDto>> categoryBooksMap) {
        this.categoryBooksMap = categoryBooksMap;
    }
    public Map<Integer, String> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<Integer, String> categoryMap) {
        this.categoryMap = categoryMap;
    }

}
