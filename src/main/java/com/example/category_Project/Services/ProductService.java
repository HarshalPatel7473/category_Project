package com.example.category_Project.Services;

import com.example.category_Project.Dto.Product;
import com.example.category_Project.Entity.ProductEntity;
import com.example.category_Project.Repositories.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductEntityRepository productEntityRepository;
    //Post
    public Product productPost(Product product, Long categoryId, Long subcategoryId){
      ProductEntity productEntityNull =
              productEntityRepository.findByNameAndCategoryIdAndSubcategoryId(product.getName()
                      ,categoryId,subcategoryId);
       if (productEntityNull==null) {
           ProductEntity productEntity = new ProductEntity();
           productEntity.setId(product.getId());
           productEntity.setCategoryId(categoryId);
           productEntity.setSubcategoryId(subcategoryId);
           productEntity.setName(product.getName());
           productEntity.setUnitOfMeasure(product.getUnitOfMeasure());
           productEntity.setWeight(product.getWeight());
           productEntity.setGST(product.getGST());
           productEntity.setPrice(product.getPrice());
           ProductEntity productEntityResult = productEntityRepository.save(productEntity);

           Product product1 = new Product();
           product1.setId(productEntityResult.getId());
           product1.setCategoryId(productEntityResult.getCategoryId());
           product1.setPrice(productEntityResult.getPrice());
           product1.setName(productEntityResult.getName());
           product1.setGST(productEntityResult.getGST());
           product1.setSubcategoryId(productEntityResult.getSubcategoryId());
           product1.setWeight(productEntityResult.getWeight());
           product1.setUnitOfMeasure(productEntityResult.getUnitOfMeasure());
           return product1;
       }else {
           return null;
       }
    }
    //Update
    public Product productUpdate(Product product, Long Id, Long CategoryId, Long SubcategoryId){
       //List<ProductEntity> productEntitySearch = productEntityRepository.search(product.getName());
       //if (productEntitySearch==null){}
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(Id);
        productEntity.setCategoryId(CategoryId);
        productEntity.setSubcategoryId(SubcategoryId);
        productEntity.setName(product.getName());
        productEntity.setUnitOfMeasure(product.getUnitOfMeasure());
        productEntity.setWeight(product.getWeight());
        productEntity.setGST(product.getGST());
        productEntity.setPrice(product.getPrice());
        ProductEntity productEntityResult = productEntityRepository.save(productEntity);

        Product product1 = new Product();
        product1.setId(productEntityResult.getId());
        product1.setCategoryId(productEntityResult.getCategoryId());
        product1.setPrice(productEntityResult.getPrice());
        product1.setName(productEntityResult.getName());
        product1.setGST(productEntityResult.getGST());
        product1.setSubcategoryId(productEntityResult.getSubcategoryId());
        product1.setWeight(productEntityResult.getWeight());
        product1.setUnitOfMeasure(productEntityResult.getUnitOfMeasure());
        return product1;
    }//else {return null;}
    //GetAll
    public List<Product> productGetAll(Long CategoryId, Long SubcategoryId){

        List<ProductEntity> productEntityList = productEntityRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();
        productEntityList.forEach(productEntity -> {
            Product product = new Product();
            product.setId(productEntity.getId());
            product.setName(productEntity.getName());
            product.setPrice(productEntity.getPrice());
            product.setWeight(productEntity.getWeight());
            product.setSubcategoryId(SubcategoryId);
            product.setCategoryId(CategoryId);
            product.setGST(productEntity.getGST());
            product.setUnitOfMeasure(productEntity.getUnitOfMeasure());
            products.add(product);
        });
        return products;
    }
    //GetId
    public Product productGetId(Long Id, Long CategoryId, Long SubcategoryId){
        ProductEntity productEntity = productEntityRepository.getById(Id);
        Product product = new Product();
        product.setId(Id);
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setWeight(productEntity.getWeight());
        product.setSubcategoryId(SubcategoryId);
        product.setCategoryId(CategoryId);
        product.setGST(productEntity.getGST());
        product.setUnitOfMeasure(productEntity.getUnitOfMeasure());
        return product;
    }
   //DeleteAll
    public void productDeleteAll(){
        productEntityRepository.deleteAll();
    }
   //DeleteById
   public void productDeleteId(Long Id){
       productEntityRepository.deleteById(Id);
   }
}