package com.example.category_Project.Resources;

import com.example.category_Project.Dto.Product;
import com.example.category_Project.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("Api/")
public class ProductResource {
    @Autowired
    ProductService productService;
    @PostMapping("Product/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<Product> ProductPost(@RequestBody Product product,
                            @PathVariable("CategoryId")Long CategoryId,
                            @PathVariable("SubcategoryId")Long SubcategoryId){
        Product productResult = productService.ProductPost(product,CategoryId,SubcategoryId);
        return ResponseEntity.ok().body(productResult);
    }
    @PutMapping("Product/{Id}/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<Product> ProductUpdate(@RequestBody Product product,
                                               @PathVariable("CategoryId")Long Id,
                                               @PathVariable("CategoryId")Long CategoryId,
                                               @PathVariable("SubcategoryId")Long SubcategoryId){
        Product productResult = productService.ProductUpdate(product,Id,CategoryId,SubcategoryId);
        return ResponseEntity.ok().body(productResult);
    }
    @GetMapping("Product/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<List<Product>> ProductGetAll(@PathVariable("CategoryId")Long CategoryId,
                                @PathVariable("SubcategoryId")Long SubcategoryId){
        List<Product> productList = productService.ProductGetAll(CategoryId,SubcategoryId);
        return ResponseEntity.ok().body(productList);
    }
    @GetMapping("Product/{Id}/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<Product> ProductGetId(@PathVariable("Id")Long Id,
                             @PathVariable("CategoryId")Long CategoryId,
                             @PathVariable("SubcategoryId")Long SubcategoryId){
        Product product = productService.ProductGetId(Id,CategoryId,SubcategoryId);
        return ResponseEntity.ok().body(product);
    }
    @DeleteMapping("Product")
    public void ProductDeleteAll(){
        productService.ProductDeleteAll();
    }

    @DeleteMapping("Product/{Id}")
    public void ProductDeleteId(@PathVariable("Id")Long Id){
        productService.ProductDeleteId(Id);
    }
}