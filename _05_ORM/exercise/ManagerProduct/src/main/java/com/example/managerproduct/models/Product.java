package com.example.managerproduct.models;

import javax.persistence.*;

@Entity(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;
    @Column (name = "name")
    private String name;
    @Column (name = "price")
    private Double price;
    @Column (name = "about")
    private String about;

    public Product() {
    }

    public Product(int id, String name, double price, String about) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.about = about;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
