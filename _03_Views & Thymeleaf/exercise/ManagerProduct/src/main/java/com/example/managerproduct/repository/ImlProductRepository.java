package com.example.managerproduct.repository;

import com.example.managerproduct.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ImlProductRepository implements IProductRepository{
    private static List<Product> productList;
    static {
        {
        productList = new ArrayList<>();
            productList.add(new Product(1,"Iphone 12",1000,"Apple"));
            productList.add(new Product(2,"Iphone 13",1500,"Apple"));
            productList.add(new Product(3,"Iphone 14",2000,"Apple"));
            productList.add(new Product(4,"Iphone 15",2500,"Apple"));
            productList.add(new Product(5,"Iphone 16",3000,"Apple"));
        }
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public void save(Product productNew) {

    }

    @Override
    public void update(Product productUpdate) {

    }

    @Override
    public void delete(int idDel) {

    }

    @Override
    public List<Product> findName(String name) {
        return null;
    }
}
