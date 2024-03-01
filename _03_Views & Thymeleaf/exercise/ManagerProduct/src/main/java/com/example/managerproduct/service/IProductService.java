package com.example.managerproduct.service;

import com.example.managerproduct.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);

    void save(Product productNew);

    void update(Product productUpdate);

    void delete(int idDel);

    List<Product> findName(String name);
}
