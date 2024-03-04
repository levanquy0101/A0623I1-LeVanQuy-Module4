package com.example.managerproduct.services.impl;

import com.example.managerproduct.models.Product;
import com.example.managerproduct.repositories.IProductRepository;
import com.example.managerproduct.repositories.impl.ImlProductRepository;
import com.example.managerproduct.services.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImlProductService implements IProductService {
    private static IProductRepository productRepository = new ImlProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product productUpdate) {

    }

    @Override
    public void delete(int idDel) {
        productRepository.delete(idDel);
    }

    @Override
    public List<Product> findName(String name) {
        return null;
    }
}
