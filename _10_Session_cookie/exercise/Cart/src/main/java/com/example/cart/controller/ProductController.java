package com.example.cart.controller;

import com.example.cart.model.Product;
import com.example.cart.model.ProductForm;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes("productCartList")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @ModelAttribute("productCartList")
    public List<Product> initSession() {
        return new ArrayList<>();
    }
    @GetMapping("")
    public String showListProduct(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList",productList);
        return "home";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new ProductForm());
        return "/create";
    }
    @PostMapping("/create")
    public String saveProduct(@ModelAttribute ProductForm productForm, RedirectAttributes redirectAttributes) throws IOException {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = iProductService.saveImage(multipartFile);
        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getDescribeP(),fileName, productForm.getPrice());
        iProductService.save(product);
        return "redirect:/product?ms=1";
    }
    @GetMapping("{id}/detail")
    public String detailProduct(Model model, @PathVariable(name = "id") Long id){
        Product product = iProductService.findById(id);
        model.addAttribute("product",product);
        return "/detail";
    }
    @GetMapping("/{id}/add-cart")
    public String addTalk(Model model, @PathVariable(name = "id") Long id,
                          @ModelAttribute("productCartList")List<Product> productCartList) {
        Product product = iProductService.findById(id);
        productCartList.add(product);
        return "redirect:/product";
    }
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }

}
