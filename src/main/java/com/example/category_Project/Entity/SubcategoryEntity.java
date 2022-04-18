package com.example.category_Project.Entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity(name = "Subcategory")
@EntityListeners(AuditingEntityListener.class)
public class SubcategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "name")
    private String name;

    public SubcategoryEntity(){};
    public SubcategoryEntity(Long id, Long categoryId, String name) {
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