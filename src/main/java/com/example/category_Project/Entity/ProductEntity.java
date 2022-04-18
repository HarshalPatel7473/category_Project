package com.example.category_Project.Entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "Product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name ="subcategory_id")
    private Long subcategoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "unit_of_measure")
    private String  unitOfMeasure;
    @Column(name = "price")
    private double price;
    @Column(name = "weight")
    private double weight;
    @Column(name = "GST")
    private double GST;

    public ProductEntity(){};
    public ProductEntity(Long id, Long categoryId,
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