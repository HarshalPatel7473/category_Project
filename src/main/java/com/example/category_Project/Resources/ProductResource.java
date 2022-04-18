package com.example.category_Project.Resources;

import com.example.category_Project.Dto.Product;
import com.example.category_Project.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("Api/")
public class ProductResource {
    @Autowired
    ProductService productService;
    @PostMapping("Product/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<Product> productPost(@RequestBody Product product,
                            @PathVariable("CategoryId")Long CategoryId,
                            @PathVariable("SubcategoryId")Long SubcategoryId){
        Product productResult = productService.productPost(product,CategoryId,SubcategoryId);
        if (productResult==null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(productResult);
    }
    @PutMapping("Product/{Id}/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<Product> productUpdate(@RequestBody Product product,
                                               @PathVariable("CategoryId")Long Id,
                                               @PathVariable("CategoryId")Long CategoryId,
                                               @PathVariable("SubcategoryId")Long SubcategoryId){
        Product productResult = productService.productUpdate(product,Id,CategoryId,SubcategoryId);
        return ResponseEntity.ok().body(productResult);
    }
    @GetMapping("Product/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<List<Product>> productGetAll(@PathVariable("CategoryId")Long CategoryId,
                                @PathVariable("SubcategoryId")Long SubcategoryId){
        List<Product> productList = productService.productGetAll(CategoryId,SubcategoryId);
        return ResponseEntity.ok().body(productList);
    }
    @GetMapping("Product/{Id}/{CategoryId}/{SubcategoryId}")
    public ResponseEntity<Product> productGetId(@PathVariable("Id")Long Id,
                             @PathVariable("CategoryId")Long CategoryId,
                             @PathVariable("SubcategoryId")Long SubcategoryId){
        Product product = productService.productGetId(Id,CategoryId,SubcategoryId);
        return ResponseEntity.ok().body(product);
    }
    @DeleteMapping("Product")
    public void productDeleteAll(){
        productService.productDeleteAll();
    }

    @DeleteMapping("Product/{Id}")
    public void productDeleteId(@PathVariable("Id")Long Id){
        productService.productDeleteId(Id);
    }
}