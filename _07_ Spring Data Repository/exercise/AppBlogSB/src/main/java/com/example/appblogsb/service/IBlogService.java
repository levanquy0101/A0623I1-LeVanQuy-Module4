package com.example.appblogsb.service;

import com.example.appblogsb.model.Blog;
import com.example.appblogsb.model.CategoryBlog;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    List<Blog> findAllByTypePost(CategoryBlog typePost);
    Blog findById(Long id);
    Blog save(Blog blog);
    void deleteById(Long id);
    String saveImage(MultipartFile file) throws IOException;

//    Blog getLatestBlog();
}
