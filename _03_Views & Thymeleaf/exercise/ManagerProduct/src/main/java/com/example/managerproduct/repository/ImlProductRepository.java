package com.example.managerproduct.repository;

import com.example.managerproduct.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        for (Product product : productList) {
            if (Objects.equals(product.getId(), id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product productNU) {
        if (productNU.getId() == 0) {
            // Nếu id là 0, tức là sản phẩm mới, thì thêm vào danh sách
            int lastID = productList.get(productList.size()-1).getId();
            productNU.setId(lastID+1);
            productList.add(productNU);
        } else {
            // Nếu id đã tồn tại, cập nhật thông tin của sản phẩm
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == productNU.getId()) {
                    productList.set(i, productNU);
                    break;
                }
            }
        }
    }

    @Override
    public void update(Product productUpdate) {

    }

    @Override
    public void delete(int idDel) {
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId() == idDel){
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public List<Product> findName(String name) {
        return null;
    }
}
