package com.example.appblog.service;

import com.example.appblog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);
    ;

    Blog findById(Integer id);

    Blog blogNew();

    void update(Blog blog);

    void delete(Integer id);
}
