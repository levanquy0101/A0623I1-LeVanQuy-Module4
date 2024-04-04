package com.example.appblogsb.repository;

import com.example.appblogsb.model.Blog;
import com.example.appblogsb.model.CategoryBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
//    Blog findFirstByOrderByCreatedAtDesc();
    List<Blog> findAllByTypePost(CategoryBlog typePost);
}
