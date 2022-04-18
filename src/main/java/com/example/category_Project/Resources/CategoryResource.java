package com.example.category_Project.Resources;

import com.example.category_Project.Dto.Category;
import com.example.category_Project.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @PostMapping("Category")
    public Category CategoryPost(@RequestBody Category category){
        System.out.println("category:"+category);
        Category categoryResult = categoryService.CategoryPost(category);
        ResponseEntity.ok().body(categoryResult);
        return categoryResult;
    }
    @GetMapping("Category")
    public ResponseEntity<List<Category>> CategoryAllGet(){
    List<Category> categoryResult = categoryService.CategoryAllGet();
    return ResponseEntity.ok().body(categoryResult);
    }
    @GetMapping("Category/{Id}")
    public ResponseEntity<Category> CategoryGetId(@PathVariable("Id")Long Id){
        Category categoryResult = categoryService.CategoryGetId(Id);
        return ResponseEntity.ok().body(categoryResult);
    }
    @DeleteMapping("Category")
    public void CategoryDeleteALL(){
            categoryService.CategoryDeleteALL();
    }
    @DeleteMapping("Category/{id}")
    public void CategoryDeleteId(@PathVariable("id")Long id){
        categoryService.CategoryDeleteId(id);
    }
    @PutMapping("Category/{id}")
    public Category CategoryUpdate(@RequestBody Category category,@PathVariable("id")Long id){
        Category categoryResult = categoryService.CategoryUpdate(category,id);
        ResponseEntity.ok().body(categoryResult);
        return categoryResult;
    }
}