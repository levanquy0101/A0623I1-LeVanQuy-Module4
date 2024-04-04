package com.example.appblogsb.service.impl;

import com.example.appblogsb.model.CategoryBlog;
import com.example.appblogsb.repository.CategoryBlogRepository;
import com.example.appblogsb.service.ICategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBlogService implements ICategoryBlogService {
    @Autowired
    private CategoryBlogRepository categoryBlogRepository;

    @Override
    public List<CategoryBlog> findAll() {
        return categoryBlogRepository.findAll();
    }

    @Override
    public CategoryBlog findById(Long id) {
        return categoryBlogRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryBlog save(CategoryBlog categoryBlog) {
        return categoryBlogRepository.save(categoryBlog);
    }

    @Override
    public void deleteById(Long id) {

    }
}
