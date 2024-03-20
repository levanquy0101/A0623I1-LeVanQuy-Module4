package com.example.cart.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private Long id;
    private String name;
    private String describeP;
    private MultipartFile image;
    private Double price;

    public ProductForm() {
    }

    public ProductForm(Long id, String name, String describeP, MultipartFile image, Double price) {
        this.id = id;
        this.name = name;
        this.describeP = describeP;
        this.image = image;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribeP() {
        return describeP;
    }

    public void setDescribeP(String describeP) {
        this.describeP = describeP;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
