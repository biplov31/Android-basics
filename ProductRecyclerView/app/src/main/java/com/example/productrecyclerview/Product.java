package com.example.productrecyclerview;

public class Product {

    private Integer id;
    private String title;
    private String description;
    private Integer color;
    private Double price;

    public Product() {
    }

    public Product(Integer id, String title, String description, Integer color, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.color = color;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
