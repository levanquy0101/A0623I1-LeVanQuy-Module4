package com.example.appblogsb.model;


import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class BlogForm {
    private Long id;
    private CategoryBlog typePost;
    private LocalDate date;
    private String author;
    private String title;
    private MultipartFile image;
    private String content;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BlogForm() {
    }

    public BlogForm(Long id, CategoryBlog typePost, LocalDate date, String author, String title, MultipartFile image, String content) {
        this.id = id;
        this.typePost = typePost;
        this.date = date;
        this.author = author;
        this.title = title;
        this.image = image;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryBlog getTypePost() {
        return typePost;
    }

    public void setTypePost(CategoryBlog typePost) {
        this.typePost = typePost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
