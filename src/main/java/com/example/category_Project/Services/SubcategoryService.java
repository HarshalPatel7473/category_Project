package com.example.category_Project.Services;
import com.example.category_Project.Dto.Subcategory;
import com.example.category_Project.Entity.SubcategoryEntity;
import com.example.category_Project.Repositories.SubcategoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubcategoryService {
    @Autowired
    SubcategoryEntityRepository subcategoryEntityRepository;
    //Post
    public Subcategory SubcategoryPost(Subcategory subcategory,Long CategoryId){
       SubcategoryEntity subcategory2 =
               subcategoryEntityRepository.findByNameAndCategoryId(subcategory.getName(),CategoryId);
        if (subcategory2==null){
        SubcategoryEntity subcategoryEntity = new SubcategoryEntity();
        subcategoryEntity.setId(subcategory.getId());
        subcategoryEntity.setCategoryId(CategoryId);
        subcategoryEntity.setName(subcategory.getName());
        SubcategoryEntity subcategoryEntityResult = subcategoryEntityRepository.save(subcategoryEntity);

        Subcategory subcategory1 = new Subcategory();
        subcategory1.setId(subcategoryEntityResult.getId());
        subcategory1.setCategoryId(subcategoryEntityResult.getCategoryId());
        subcategory1.setName(subcategoryEntityResult.getName());
        return subcategory1;

        }else {
            return null;
        }
    }
    //GetAll
    public List<Subcategory> subcategoryGeTAll(Long CategoryId){
        List<SubcategoryEntity> subcategoryEntityList = subcategoryEntityRepository.findAll();

        ArrayList<Subcategory> subcategories = new ArrayList<>();
        subcategoryEntityList.forEach(subcategoryEntity -> {
            Subcategory subcategory = new Subcategory();
            subcategory.setId(subcategoryEntity.getId());
            subcategory.setCategoryId(CategoryId);
            subcategory.setName(subcategoryEntity.getName());
            subcategories.add(subcategory);
        });
        return subcategories;
    }
    //GetId
    public Subcategory SubcategoryGetId(Long Id,Long CategoryId){
        SubcategoryEntity subcategoryEntity = subcategoryEntityRepository.getById(Id);

        Subcategory subcategory = new Subcategory();
        subcategory.setId(Id);
        subcategory.setCategoryId(CategoryId);
        subcategory.setName(subcategoryEntity.getName());
        return subcategory;
    }
    //DeleteAll
    public void SubcategoryDeleteAll(){
        subcategoryEntityRepository.deleteAll();
    }
    //DeleteById
    public void SubcategoryDeleteId(Long id){
        subcategoryEntityRepository.deleteById(id);
    }
    //Update
    public Subcategory SubcategoryUpdate(Subcategory subcategory,Long Id,Long CategoryId){
        SubcategoryEntity subcategoryEntity = new SubcategoryEntity();
        subcategoryEntity.setId(Id);
        subcategoryEntity.setCategoryId(CategoryId);
        subcategoryEntity.setName(subcategory.getName());
        SubcategoryEntity subcategoryEntityResult = subcategoryEntityRepository.save(subcategoryEntity);

        Subcategory subcategory1 = new Subcategory();
        subcategory1.setId(subcategoryEntityResult.getId());
        subcategory1.setCategoryId(subcategoryEntityResult.getCategoryId());
        subcategory1.setName(subcategoryEntityResult.getName());
        return subcategory1;
    }

}