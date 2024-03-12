package com.example.appblog.model;


import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Integer id;
    private String author;
    private String title;
    private MultipartFile image;
    private String content;

    public BlogForm() {
    }

    public BlogForm(Integer id, String author, String title, MultipartFile image, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.image = image;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
