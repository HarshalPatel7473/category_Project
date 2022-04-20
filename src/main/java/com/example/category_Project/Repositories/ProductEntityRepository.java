package com.example.category_Project.Repositories;

import com.example.category_Project.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity,Long> {
    @Override
    List<ProductEntity> findAll();
    public ProductEntity findByNameAndCategoryIdAndSubcategoryId(String name
            ,Long categoryId,Long subcategoryId);
/*    @Query("value = select * from\" +\n" +
           "     //       \" category_Project.Product where\" +\n" +
           "       //     \" concat(Product.name,Product.price,Product.weight,Product.GST" +
            " LIKE %?1%, nativeQuery = true")
    public List<ProductEntity> search(String name); */

    // @Query("select * from" +
     //       " category_Project.Product where" +
       //     " concat(Product.name,Product.price,Product.weight,Product.GST");
   }