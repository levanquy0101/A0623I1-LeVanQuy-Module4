package com.example.managerproduct.service;

import com.example.managerproduct.model.Product;
import com.example.managerproduct.repository.IProductRepository;
import com.example.managerproduct.repository.ImlProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImlProductService implements IProductService{
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
