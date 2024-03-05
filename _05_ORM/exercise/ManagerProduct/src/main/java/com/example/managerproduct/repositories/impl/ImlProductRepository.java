package com.example.managerproduct.repositories.impl;

import com.example.managerproduct.models.Product;
import com.example.managerproduct.repositories.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ImlProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> list = BaseRepository.entityManager
                .createQuery("SELECT s FROM Products s", Product.class)
                .getResultList();
        return list;
    }

    @Override
    public Product findById(Integer id) {
        Product product = BaseRepository.entityManager.find(Product.class,id);
        return product;
    }
    @Transactional
    @Override
    public void save(Product productN) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(productN);
        entityTransaction.commit();

    }
    @Transactional
    @Override
    public void update(Product productUpdate) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(productUpdate);
        entityTransaction.commit();
    }
    @Transactional
    @Override
    public void delete(int idDel) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class,idDel);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> findName(String name) {
        return null;
    }
}
