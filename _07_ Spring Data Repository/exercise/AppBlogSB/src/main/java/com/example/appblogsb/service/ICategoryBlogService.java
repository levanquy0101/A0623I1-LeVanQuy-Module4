package com.example.appblogsb.service;

import com.example.appblogsb.model.CategoryBlog;

import java.util.List;

public interface ICategoryBlogService {
    List<CategoryBlog> findAll();
    CategoryBlog findById(Long id);
    CategoryBlog save(CategoryBlog blog);
    void deleteById(Long id);
}
