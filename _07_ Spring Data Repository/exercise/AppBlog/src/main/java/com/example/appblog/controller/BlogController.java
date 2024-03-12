package com.example.appblog.controller;

import com.example.appblog.model.Blog;
import com.example.appblog.model.BlogForm;
import com.example.appblog.service.IBlogService;
import com.example.appblog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("blog")
@PropertySource("classpath:upload_file.properties")
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;
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
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blogForm", new BlogForm());
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable(name = "id") Integer id){
        iBlogService.delete(id);
        return "redirect:/blog?ms=1";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute BlogForm blogForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = blogForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blogForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Blog blog = new Blog(blogForm.getId(), blogForm.getAuthor(),
                blogForm.getTitle(), fileName, blogForm.getContent());
        iBlogService.save(blog);

        // Add a flash attribute to pass data to the redirected page
//        redirectAttributes.addFlashAttribute("blogForm", blogForm);

        // Redirect to the "/create" page
        return "redirect:/blog?ms=1";
    }



    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, BindingResult bindingResult,
                            RedirectAttributes redirect){
        if(bindingResult.hasErrors()) {
            return "/home";
        }
        iBlogService.update(blog);
        String idUpdate = "/blog/" + blog.getId() + "?ms=1";
        return "redirect:"+idUpdate;
    }
}
