package com.example.appblog.controller;

import com.example.appblog.model.Blog;
import com.example.appblog.service.IBlogService;
import com.example.appblog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService = new BlogService();
    @GetMapping("")
    public String home(Model model) {
        List<Blog> blogList = iBlogService.findAll();
        Collections.reverse(blogList);
        model.addAttribute("blogList", blogList);
        Blog blog = iBlogService.blogNew();
        if(blog != null){
            model.addAttribute("blog", blog);
        }
        return "/home";
    }
    @GetMapping("/{id}")
    public String getBlogById(@PathVariable Integer id, Model model) {
        List<Blog> blogList = iBlogService.findAll();
        Collections.reverse(blogList);
        model.addAttribute("blogList", blogList);
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "/home";
    }
    @GetMapping("/create")
    public String showCreate(@ModelAttribute("blog") Blog blog){
        return "/create";
    }
    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable(name = "id") Integer id){
        iBlogService.delete(id);
        return "redirect:/blog?ms=1";
    }

    @PostMapping("/create")
    public String createNew(@ModelAttribute("blog") Blog blog, BindingResult bindingResult,
                            RedirectAttributes redirect){
        if(bindingResult.hasErrors()) {
            return "/create";
        }
        iBlogService.save(blog);
        return "redirect:/blog?ms=1";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, BindingResult bindingResult,
                            RedirectAttributes redirect){
        if(bindingResult.hasErrors()) {
            return "/home";
        }
        iBlogService.update(blog);
        return "redirect:/blog?ms=1";
    }

}
