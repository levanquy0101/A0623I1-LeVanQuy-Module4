package com.example.cart.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String describeP;
    @Column
    private String image;
    @Column
    private Double price;

    public Product() {
    }

    public Product(Long id, String name, String describeP, String image, Double price) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
