package com.example.monetaryconversion.controller;

import com.example.monetaryconversion.model.Convert;
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
    @PostMapping("/convert")
    public ModelAndView convert(Convert cunrrency){
        ModelAndView modelAndView= new ModelAndView("detail");
        double result= cunrrency.getUsd() * cunrrency.getRate();
        modelAndView.addObject("result", String.format("%.2f", result));
        return modelAndView;
    }
}
