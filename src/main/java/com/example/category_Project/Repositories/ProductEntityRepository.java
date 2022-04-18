package com.example.category_Project.Repositories;

import com.example.category_Project.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity,Long> {
    @Override
    List<ProductEntity> findAll();
    public ProductEntity findByNameAndCategoryIdAndSubcategoryId(String name
            ,Long categoryId,Long subcategoryId);
}