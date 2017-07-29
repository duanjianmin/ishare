package com.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LYJ on 2016/9/27.
 */

@Table(catalog = "ishare", name = "book_resource")
@Entity
public class BookResource {

    @GeneratedValue
    @Id
    @Column(name = "bookResourceId")
    private Integer id;

    @Column(name = "bookId")
    private Integer bookId;

    @Column(name = "resourceName")
    private String resourceName;

    @Column(name = "resourceType")
    private String resourceType;

    @Column(name = "size")
    private String size;

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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
