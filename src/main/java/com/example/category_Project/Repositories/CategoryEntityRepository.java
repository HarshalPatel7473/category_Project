package com.example.category_Project.Repositories;

import com.example.category_Project.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Long> {
    @Override
    List<CategoryEntity> findAll();
    public CategoryEntity findByName(String name);
}