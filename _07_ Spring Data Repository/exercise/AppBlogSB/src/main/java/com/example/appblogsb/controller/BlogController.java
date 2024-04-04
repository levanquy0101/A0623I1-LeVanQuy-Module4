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
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryBlogService categoryBlogService;

    @GetMapping("/list")
    public String getAllBlogs(Model model) {
        try{
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        }catch (Exception e){
            System.out.println("Không tìm thấy bản ghi nào"+e);
        }
        return "blog_list";
    }

    @GetMapping( "/{id}")
    public String getBlogById(@PathVariable Long id, Model model) {
        try{
            Blog blog = blogService.findById(id);
            if(blog != null){
                model.addAttribute("blog", blog);
            }

        }catch (Exception e){
            System.out.println("Không tìm thấy bản ghi nào"+e);
        }
        return "view";
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
        blogForm.setDate(blog.getDate());
        model.addAttribute("currentDate",blogForm.getDate());
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
        Blog blog = new Blog(blogForm.getId(),blogForm.getTypePost(),blogForm.getDate(), blogForm.getAuthor(),
                blogForm.getTitle(), fileName, blogForm.getContent());
        blogService.save(blog);
        return "redirect:/blogs/list?ms=1";
    }

    @GetMapping ("/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteById(id);
        return "redirect:/blogs/list";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute BlogForm blogForm, RedirectAttributes redirectAttributes) throws IOException {
        MultipartFile multipartFile = blogForm.getImage();
        if (!multipartFile.isEmpty()) {
            String fileName = blogService.saveImage(multipartFile);
            Blog blog = new Blog(blogForm.getId(), blogForm.getTypePost(),blogForm.getDate(), blogForm.getAuthor(),
                    blogForm.getTitle(), fileName, blogForm.getContent());
            blogService.save(blog);
        } else {
            Blog blog = new Blog(blogForm.getId(), blogForm.getTypePost(), blogForm.getDate(),blogForm.getAuthor(),
                    blogForm.getTitle(),blogForm.getImageUrl(), blogForm.getContent());
            blogService.save(blog);
        }
        return "redirect:/blogs/list?ms=1";
    }

}
