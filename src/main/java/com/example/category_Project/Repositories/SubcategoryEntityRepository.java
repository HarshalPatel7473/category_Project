package com.example.category_Project.Repositories;

import com.example.category_Project.Entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryEntityRepository extends JpaRepository<SubcategoryEntity,Long> {
    @Override
    List<SubcategoryEntity> findAll();
}