package com.example.appblogsb.service.impl;

import com.example.appblogsb.model.Blog;
import com.example.appblogsb.model.CategoryBlog;
import com.example.appblogsb.repository.BlogRepository;
import com.example.appblogsb.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByTypePost(CategoryBlog typePost) {
        return blogRepository.findAllByTypePost(typePost);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String saveImage(MultipartFile file) throws IOException {
        // Tạo đường dẫn lưu trữ ảnh
        String fileName = file.getOriginalFilename();
        String filePath = uploadDir + "/" + fileName;

        // Lưu ảnh vào hệ thống tệp
        File dest = new File(filePath);
        file.transferTo(dest);

        return fileName;
    }

}
