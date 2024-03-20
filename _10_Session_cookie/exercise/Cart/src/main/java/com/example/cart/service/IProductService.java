package com.example.cart.service;

import com.example.cart.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    String saveImage(MultipartFile file) throws IOException;

    void save(Product product);

    List<Product> findAll();

    Product findById(Long id);
}
