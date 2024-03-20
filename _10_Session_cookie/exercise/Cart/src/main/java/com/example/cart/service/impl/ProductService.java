package com.example.cart.service.impl;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String saveImage(MultipartFile file) throws IOException {
        // Tạo đường dẫn lưu trữ ảnh
        String fileName = file.getOriginalFilename();
        String filePath = uploadDir + "/" + fileName;

        // Lưu ảnh vào hệ thống tệp
        File dest = new File(filePath);
        file.transferTo(dest);

        return fileName;
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
