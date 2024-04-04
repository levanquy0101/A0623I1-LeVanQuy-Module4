package com.example.appblogsb.controller;

import com.example.appblogsb.model.Blog;
import com.example.appblogsb.model.CategoryBlog;
import com.example.appblogsb.service.IBlogService;
import com.example.appblogsb.service.ICategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryBlogService categoryBlogService;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> showCategory(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            CategoryBlog categoryBlog = categoryBlogService.findById(id);
            if (categoryBlog == null) {
                response.put("error", "Category not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            List<Blog> blogList = blogService.findAllByTypePost(categoryBlog);
            response.put("category", categoryBlog);
            response.put("blogs", blogList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
