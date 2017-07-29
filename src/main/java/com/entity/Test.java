package com.entity;
import javax.persistence.*;

/**
 * Created by LYJ on 2016/9/27.
 */

@Table(catalog = "ishare", name = "test")
@Entity
public class Test {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @GeneratedValue
    @Id
    private Integer id;


    @Column(name="name")
    private String name;

    @Column(name="number")
    private Integer number;

}
