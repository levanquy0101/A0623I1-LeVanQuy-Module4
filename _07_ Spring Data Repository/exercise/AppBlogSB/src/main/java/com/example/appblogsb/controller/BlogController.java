package com.example.appblogsb.controller;

import com.example.appblogsb.model.Blog;
import com.example.appblogsb.model.BlogForm;
import com.example.appblogsb.service.IBlogService;
import com.example.appblogsb.service.ICategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryBlogService categoryBlogService;

    @GetMapping
    public String getAllBlogs(Model model) {
        try{
        List<Blog> blogList = blogService.findAll();
        Collections.reverse(blogList);
        model.addAttribute("blogList", blogList);
        Blog blogLast= blogList.get(0);
        if(blogLast != null){
            model.addAttribute("blog", blogLast);
        }
        }catch (Exception e){
            System.out.println("Không tìm thấy bản ghi nào"+e);
        }

        //Danh sách loại bài viết
        model.addAttribute("typePosts",categoryBlogService.findAll());
        List<Blog> blogsNum1= blogService.findAll();
        model.addAttribute("blogsNum1",blogsNum1);
//        model.addAttribute()

        return "home";
    }

    @GetMapping( "/{id}")
    public String getBlogById(@PathVariable Long id, Model model) {
        try{
            List<Blog> blogList = blogService.findAll();
            Collections.reverse(blogList);
            model.addAttribute("blogList", blogList);
            Blog blog = blogService.findById(id);
            if(blog != null){
                model.addAttribute("blog", blog);
            }

        }catch (Exception e){
            System.out.println("Không tìm thấy bản ghi nào"+e);
        }
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blogForm", new BlogForm());
        modelAndView.addObject("typePosts", categoryBlogService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/update")
    public String showUpdate(Model model, @PathVariable(name = "id") Long id){
        Blog blog = blogService.findById(id);
        BlogForm blogForm = new BlogForm();
        blogForm.setId(blog.getId());
        blogForm.setTypePost(blog.getTypePost());
        blogForm.setAuthor(blog.getAuthor());
        blogForm.setTitle(blog.getTitle());
        blogForm.setImageUrl(blog.getImage());
        blogForm.setContent(blog.getContent());
        model.addAttribute("blogForm",blogForm );
        model.addAttribute("typePosts",categoryBlogService.findAll());
        return "/update";
    }
    @PostMapping("/create")
    public String saveProduct(@ModelAttribute BlogForm blogForm, RedirectAttributes redirectAttributes) throws IOException {
        MultipartFile multipartFile = blogForm.getImage();
        String fileName = blogService.saveImage(multipartFile);
        Blog blog = new Blog(blogForm.getId(),blogForm.getTypePost(), blogForm.getAuthor(),
                blogForm.getTitle(), fileName, blogForm.getContent());
        blogService.save(blog);
        return "redirect:/blogs?ms=1";
    }

    @GetMapping ("/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteById(id);
        return "redirect:/blogs";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute BlogForm blogForm, RedirectAttributes redirectAttributes) throws IOException {
        MultipartFile multipartFile = blogForm.getImage();
        if (!multipartFile.isEmpty()) {
            String fileName = blogService.saveImage(multipartFile);
            Blog blog = new Blog(blogForm.getId(), blogForm.getTypePost(), blogForm.getAuthor(),
                    blogForm.getTitle(), fileName, blogForm.getContent());
            blogService.save(blog);
        } else {
            Blog blog = new Blog(blogForm.getId(), blogForm.getTypePost(), blogForm.getAuthor(),
                    blogForm.getTitle(),blogForm.getImageUrl(), blogForm.getContent());
            blogService.save(blog);
        }
        return "redirect:/blogs?ms=1";
    }

}
