package com.example.validateregister.controller;

import com.example.validateregister.model.User;
import com.example.validateregister.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/new")
    public String showCreate(Model model){
        User user = new User();
        model.addAttribute(user);
        return "home";
    }
    @PostMapping("/new")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/home";
        }
        System.out.println(user.toString());
        iUserService.save(user);
        return "/result";
    }
}
