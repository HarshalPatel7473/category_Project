package com.example.category_Project.Dto;

public class Subcategory {
    private Long id;
    private Long categoryId;
    private String name;

    public Subcategory(){};
    public Subcategory(Long id, Long categoryId, String name) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}