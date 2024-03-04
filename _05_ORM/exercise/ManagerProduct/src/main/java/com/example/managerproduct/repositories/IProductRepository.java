package com.example.managerproduct.repositories;

import com.example.managerproduct.models.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);

    void save(Product productN);

    void update(Product productUpdate);

    void delete(int idDel);

    List<Product> findName(String name);
}
