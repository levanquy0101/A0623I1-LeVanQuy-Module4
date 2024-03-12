package com.example.appblog.service.impl;

import com.example.appblog.model.Blog;
import com.example.appblog.repository.IBlogRepository;
import com.example.appblog.repository.impl.BlogRepository;
import com.example.appblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository = new BlogRepository();
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Blog blogNew() {
        return iBlogRepository.blogNew();
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.delete(id);
    }

}
