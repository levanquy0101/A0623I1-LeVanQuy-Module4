package com.example.appblog.repository.impl;

import com.example.appblog.model.Blog;
import com.example.appblog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
    @Override
    public List<Blog> findAll() {
        List<Blog> list = BaseRepository.entityManager
                .createQuery("SELECT s FROM blog s", Blog.class)
                .getResultList();
        return list;
    }

    @Override
    public void save(Blog blog) {
        entityTransaction.begin();
        BaseRepository.entityManager.persist(blog);
        entityTransaction.commit();
    }

    @Override
    public Blog findById(Integer id) {
        return BaseRepository.entityManager.find(Blog.class,id);
    }

    @Override
    public Blog blogNew() {

        try {
            String jpql = "SELECT b FROM blog b ORDER BY b.id DESC";
            Query query = BaseRepository.entityManager.createQuery(jpql);
            query.setMaxResults(1);
            return (Blog) query.getSingleResult();
        }catch (Exception e){
            System.out.println("Không tìm thấy bài viết nào!" + e.getMessage());
            return null;
        }
    }

    @Override
    public void update(Blog blog) {
        entityTransaction.begin();
        BaseRepository.entityManager.merge(blog);
        entityTransaction.commit();
    }

    @Override
    public void delete(Integer id) {
        entityTransaction.begin();
        Blog blog = BaseRepository.entityManager.find(Blog.class,id);
        BaseRepository.entityManager.remove(blog);
        entityTransaction.commit();
    }

}
