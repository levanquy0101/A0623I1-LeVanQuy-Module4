package com.example.simpledictionary.controller;

import com.example.simpledictionary.model.Convert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppServlet {
    @GetMapping
    public String home(){
        return "/home";
    }
    @PostMapping("/home")
    public ModelAndView convert(Convert cunrrency){
        ModelAndView modelAndView= new ModelAndView("detail");
//        String messResult =
        return modelAndView;
    }
}
