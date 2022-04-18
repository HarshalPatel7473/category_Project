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

    public Category categorySave(Category category){
        CategoryEntity categoryEntitie = categoryEntityRepository.findByName(category.getName());
        if(categoryEntitie == null){
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(category.getId());
            categoryEntity.setName(category.getName());
            CategoryEntity categoryEntityResult = categoryEntityRepository.save(categoryEntity);

            Category category1 = new Category();
            category1.setId(categoryEntityResult.getId());
            category1.setName(categoryEntityResult.getName());
            return category1;
        }else{
            return  null;
        }
    }
    // GetAll
    public List<Category> categoryAllGet(){
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
    public Category categoryGetId(Long id){
        CategoryEntity categoryEntity = categoryEntityRepository.getById(id);

        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    }
    //DeleteALL
    public void categoryDeleteALL() {
        categoryEntityRepository.deleteAll();
    }
    //DeleteId
    public void categoryDeleteId(Long id) {
        categoryEntityRepository.deleteById(id);
    }
    //Update
    public Category categoryUpdate(Category category, Long id){
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