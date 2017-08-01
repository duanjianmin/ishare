package com.dto;

import java.util.*;

/**
 * Created by LYJ on 2016/9/27.
 */

public class BookDto {

    private Integer id;

    private String bookName;

    private Integer bookCategoryId;

    private String remark;

    private String author;

    private String pictureName;

    private String introduction;

    private String amazonLink;

    private String label;

    private Integer downloadFrequency;

    private Double doubanStar;

    private boolean usable;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private String resourceType;

    private Integer pageNumber;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    private Map<Integer,String> categoryMap = new LinkedHashMap<>();

    private String fileServerPrefix;

    private List<BookResourceDto> bookResourceDtoList = new ArrayList<>();

    public List<BookResourceDto> getBookResourceDtoList() {
        return bookResourceDtoList;
    }

    public void setBookResourceDtoList(List<BookResourceDto> bookResourceDtoList) {
        this.bookResourceDtoList = bookResourceDtoList;
    }

    public String getFileServerPrefix() {
        return fileServerPrefix;
    }

    public void setFileServerPrefix(String fileServerPrefix) {
        this.fileServerPrefix = fileServerPrefix;
    }

    public Map<Integer, String> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<Integer, String> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAmazonLink() {
        return amazonLink;
    }

    public void setAmazonLink(String amazonLink) {
        this.amazonLink = amazonLink;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getDownloadFrequency() {
        return downloadFrequency;
    }

    public void setDownloadFrequency(Integer downloadFrequency) {
        this.downloadFrequency = downloadFrequency;
    }

    public Double getDoubanStar() {
        return doubanStar;
    }

    public void setDoubanStar(Double doubanStar) {
        this.doubanStar = doubanStar;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}
