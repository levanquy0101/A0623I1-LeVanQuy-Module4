package com.example.appblogsb.model;

import jakarta.persistence.*;

@Entity(name = "category")
public class CategoryBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "type_post")
    private String nameType;

    public CategoryBlog() {
    }

    public CategoryBlog(Long id, String nameType) {
        this.id = id;
        this.nameType = nameType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
