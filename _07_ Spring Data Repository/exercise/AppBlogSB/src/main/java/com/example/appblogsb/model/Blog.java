package com.example.appblogsb.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "code_type_post")
    private CategoryBlog typePost;
    @Column
    private LocalDate date;
    @Column
    private String author;
    @Column
    private String title;
    @Column
    private String image;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Blog() {
    }


    public Blog(Long id, CategoryBlog typePost, LocalDate date, String author, String title, String image, String content) {
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

    public CategoryBlog getTypePost() {
        return typePost;
    }

    public void setTypePost(CategoryBlog typePost) {
        this.typePost = typePost;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
