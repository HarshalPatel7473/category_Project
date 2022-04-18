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
    public ResponseEntity<Category> categoryPost(@RequestBody Category category){
        System.out.println("category:"+category);
        Category categoryResult = categoryService.categorySave(category);
        if (categoryResult==null){
            return ResponseEntity.badRequest().body(null);
        }
       return ResponseEntity.ok().body(categoryResult);

    }
    @GetMapping("Category")
    public ResponseEntity<List<Category>> categoryAllGet(){
    List<Category> categoryResult = categoryService.categoryAllGet();
    return ResponseEntity.ok().body(categoryResult);
    }
    @GetMapping("Category/{Id}")
    public ResponseEntity<Category> categoryGetId(@PathVariable("Id")Long Id){
        Category categoryResult = categoryService.categoryGetId(Id);
        return ResponseEntity.ok().body(categoryResult);
    }
    @DeleteMapping("Category")
    public void categoryDeleteALL(){
            categoryService.categoryDeleteALL();
    }
    @DeleteMapping("Category/{id}")
    public void categoryDeleteId(@PathVariable("id")Long id){
        categoryService.categoryDeleteId(id);
    }
    @PutMapping("Category/{id}")
    public Category categoryUpdate(@RequestBody Category category,@PathVariable("id")Long id){
        Category categoryResult = categoryService.categoryUpdate(category,id);
        ResponseEntity.ok().body(categoryResult);
        return categoryResult;
    }
}