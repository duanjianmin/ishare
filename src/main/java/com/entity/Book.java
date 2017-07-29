package com.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LYJ on 2016/9/27.
 */

@Table(catalog = "ishare", name = "book")
@Entity
public class Book {

    @GeneratedValue
    @Id
    @Column(name = "bookId")
    private Integer id;


    @Column(name = "bookName")
    private String bookName;

    @Column(name = "bookCategoryId")
    private Integer bookCategoryId;

    @Column(name = "remark")
    private String remark;

    @Column(name = "author")
    private String author;

    @Column(name = "pictureName")
    private String pictureName;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "amazonLink")
    private String amazonLink;

    @Column(name = "label")
    private String label;

    @Column(name = "downloadFrequency")
    private Integer downloadFrequency;

    @Column(name = "doubanStar")
    private Double doubanStar;

    @Column(name = "usable")
    private boolean usable;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @Column(name = "updatedBy")
    private String updatedBy;

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

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
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
}
