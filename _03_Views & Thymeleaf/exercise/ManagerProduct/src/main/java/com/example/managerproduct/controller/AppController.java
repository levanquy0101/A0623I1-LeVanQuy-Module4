package com.example.managerproduct.controller;

import com.example.managerproduct.model.Product;
import com.example.managerproduct.service.ImlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("Products")
public class AppController {
    @Autowired
    private ImlProductService imlProductService;
    @GetMapping("")
    public String home(Model model){
        List<Product> productList = imlProductService.findAll();
        model.addAttribute("productList", productList);
        return "product/home";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("productNew", new Product());
        return "product/create";
    }
    @GetMapping("/{id}/update")
    public String showUpdate(Model model, @PathVariable(name = "id") Integer id){
        Product product = imlProductService.findById(id);
        model.addAttribute("product", product);
        return "product/update";
    }
    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable(name = "id") Integer id){
        imlProductService.delete(id);
        return "redirect:/Products?ms=1";
    }
    @PostMapping("create")
    public String createNew(@ModelAttribute("product") Product product, BindingResult bindingResult,
                            RedirectAttributes redirect){
        if(bindingResult.hasErrors()) {
            return "product/create";
        }
        product.setId(0);
        imlProductService.save(product);
        return "redirect:/Products?ms=1";
    }
    @PostMapping("update")
    public String update(@ModelAttribute("product") Product product, BindingResult bindingResult,
                            RedirectAttributes redirect){
        if(bindingResult.hasErrors()) {
            return "product/update";
        }
        imlProductService.save(product);
        return "redirect:/Products?ms=1";
    }

}
