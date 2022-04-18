package com.example.category_Project.Dto;

public class Product {
    private Long id;
    private Long categoryId;
    private Long subcategoryId;
    private String name;
    private String  unitOfMeasure;
    private double price;
    private double weight;
    private double GST;

    public Product(){};
    public Product(Long id, Long categoryId,
                   Long subcategoryId, String name, String unitOfMeasure, double price, double weight, double GST) {
        this.id = id;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
        this.name = name;
        this.unitOfMeasure = unitOfMeasure;
        this.price = price;
        this.weight = weight;
        this.GST = GST;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGST() {
        return GST;
    }

    public void setGST(double GST) {
        this.GST = GST;
    }
}