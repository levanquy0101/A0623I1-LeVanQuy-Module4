package com.example.cart.controller;

import com.example.cart.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String viewCartList(@SessionAttribute("productCartList") List<Product> productCartList,
                               Model model) {
        model.addAttribute("productCartList", productCartList);
        model.addAttribute("countCart",productCartList.size());
        return "/cart";
    }
}
