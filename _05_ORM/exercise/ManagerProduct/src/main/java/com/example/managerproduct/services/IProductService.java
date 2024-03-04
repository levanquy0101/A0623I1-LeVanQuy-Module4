package com.example.managerproduct.services;

import com.example.managerproduct.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);

    void save(Product productNew);

    void update(Product productUpdate);

    void delete(int idDel);

    List<Product> findName(String name);
}
