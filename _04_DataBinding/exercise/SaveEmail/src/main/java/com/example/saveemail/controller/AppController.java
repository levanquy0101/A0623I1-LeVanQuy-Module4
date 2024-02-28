package com.example.saveemail.controller;

import com.example.saveemail.model.EmailModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @GetMapping
    public String home(Model model){

        String language = "lang2";
        Integer pageSize = 100;
        Boolean spams = true;
        String signature = "Thân ái cảm ơn";
        EmailModel emailModel = new EmailModel(language,pageSize,spams,signature);
        model.addAttribute("emailModel",emailModel);
        return "home";
    }
    @PostMapping(value = "handel")
    public String show(@RequestParam  String language, @RequestParam Integer pageSize, @RequestParam Boolean spams, @RequestParam String signature,Model model ){
        EmailModel emailModel = new EmailModel(language, pageSize, spams,signature);
        model.addAttribute("emailModel",emailModel);
        model.addAttribute("message","Đã cập nhật lại dữ liệu");
        return "home";
    }
}
