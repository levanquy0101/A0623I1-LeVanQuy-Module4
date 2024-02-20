package com.example.simpledictionary.controller;

import com.example.simpledictionary.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AppController {
    private AppService dictionary = new AppService();

    @GetMapping
    public String home(){
        return "/home";
    }
    @PostMapping(value = "/translate", produces = "text/plain; charset=UTF-8")
     public String translate(@RequestParam("englishWord") String englishWord, Model model) {
        String vietnameseTranslation = dictionary.translate(englishWord);
        model.addAttribute("result", vietnameseTranslation);
        return "home";
    }
}
