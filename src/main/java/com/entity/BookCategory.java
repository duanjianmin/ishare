package com.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tony.duan on 4/23/17.
 */
@Table(catalog = "ishare", name = "book_category")
@Entity
public class BookCategory {
    @GeneratedValue
    @Id
    @Column(name="bookCategoryId")
    private Integer id;


    @Column(name="categoryName")
    private String categoryName;

    @Column(name="comments")
    private String comments;

    @Column(name="usable")
    private boolean usable;

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name="createdBy")
    private String createdBy;

    @Column(name="updatedAt")
    private Date updatedAt;

    @Column(name="updatedBy")
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
}
