package com.example.category_Project.Services;

import com.example.category_Project.Dto.Category;
import com.example.category_Project.Entity.CategoryEntity;
import com.example.category_Project.Repositories.CategoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    // CategoryPost(save)

    public Category CategoryPost(Category category){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        CategoryEntity categoryEntityResult = categoryEntityRepository.save(categoryEntity);

        Category category1 = new Category();
        category1.setId(categoryEntityResult.getId());
        category1.setName(categoryEntityResult.getName());
        return category1;
    }
    // GetAll
    public List<Category> CategoryAllGet(){
        List<CategoryEntity> categoryEntityList = categoryEntityRepository.findAll();

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryEntityList.forEach(categoryEntity -> {
            Category category = new Category();
            category.setId(categoryEntity.getId());
            category.setName(categoryEntity.getName());
            categoryList.add(category);
        });
        return categoryList;
    }
    //GetId
    public Category CategoryGetId(Long Id){
        CategoryEntity categoryEntity = categoryEntityRepository.getById(Id);

        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    }
    //DeleteALL
    public void CategoryDeleteALL() {
        categoryEntityRepository.deleteAll();
    }
    //DeleteId
    public void CategoryDeleteId(Long id) {
        categoryEntityRepository.deleteById(id);
    }
    //Update
    public Category CategoryUpdate(Category category,Long id){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(id);
        categoryEntity.setName(category.getName());
        CategoryEntity categoryEntityResult = categoryEntityRepository.save(categoryEntity);

        Category category1 = new Category();
        category1.setId(categoryEntityResult.getId());
        category1.setName(categoryEntityResult.getName());
        return category1;
    }
}