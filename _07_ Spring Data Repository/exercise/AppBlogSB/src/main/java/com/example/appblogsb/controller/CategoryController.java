package com.example.appblogsb.controller;

import com.example.appblogsb.model.Blog;
import com.example.appblogsb.model.CategoryBlog;
import com.example.appblogsb.service.IBlogService;
import com.example.appblogsb.service.ICategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryBlogService categoryBlogService;
    @GetMapping("/{id}")
    public String showCategory(@PathVariable Long id, Model model){
        List<CategoryBlog> categoryBlogList = categoryBlogService.findAll();
        model.addAttribute("categoryList",categoryBlogList);

        CategoryBlog categoryBlog = categoryBlogService.findById(id);
        List<Blog> blogList = blogService.findAllByTypePost(categoryBlog);

        model.addAttribute("blogList", blogList);
        return "category";
    }
}
