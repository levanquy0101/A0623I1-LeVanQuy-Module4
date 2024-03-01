package com.example.managerproduct.controller;

import com.example.managerproduct.model.Product;
import com.example.managerproduct.repository.ImlProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {
    private ImlProductRepository imlProductRepository;

    public AppController(ImlProductRepository imlProductRepository) {
        this.imlProductRepository = imlProductRepository;
    }
    @GetMapping("")
    public String home(Model model){
        List<Product> productList = imlProductRepository.findAll();
        model.addAttribute("productList", productList);
        return "product/home";
    }
    @GetMapping("/create")
    public String create(Model model){
//        model.addAttribute("product", new Product());
        return "product/create";
    }    @GetMapping("/update")
    public String update(Model model){
//        model.addAttribute("product", new Product());
        return "product/update";
    }
}
