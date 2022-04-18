package com.example.category_Project.Resources;

import com.example.category_Project.Dto.Subcategory;
import com.example.category_Project.Services.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/")
public class SubcategoryResource {
    @Autowired
    SubcategoryService subcategoryService;

    @PostMapping("Subcategory/{CategoryId}")
    public ResponseEntity<Subcategory> subcategoryPost(@RequestBody Subcategory subcategory,
                                @PathVariable("CategoryId")Long CategoryId){
    Subcategory subcategoryResult = subcategoryService.SubcategoryPost(subcategory,CategoryId);
    if (subcategoryResult==null){
       return ResponseEntity.badRequest().body(null);
    }
      return ResponseEntity.ok().body(subcategoryResult);
    }
    @GetMapping("Subcategory/{CategoryId}")
    public ResponseEntity<List<Subcategory>> subcategoryGeTAll(@PathVariable("CategoryId")Long CategoryId){
        List<Subcategory> subcategoryList = subcategoryService.subcategoryGeTAll(CategoryId);
        return ResponseEntity.ok().body(subcategoryList);
    }
    @GetMapping("Subcategory/{Id}/{CategoryId}")
    public ResponseEntity<Subcategory> subcategoryGetId(@PathVariable("Id")Long Id,
                                 @PathVariable("CategoryId")Long CategoryId){
      Subcategory subcategory = subcategoryService.SubcategoryGetId(Id,CategoryId);
      return ResponseEntity.ok().body(subcategory);
    }
    @DeleteMapping("Subcategory")
    public void subcategoryDeleteAll(){
        subcategoryService.SubcategoryDeleteAll();
    }
    @DeleteMapping("Subcategory/{id}")
    public void subcategoryDeleteId(@PathVariable("id")Long id){
        subcategoryService.SubcategoryDeleteId(id);
    }
    @PutMapping("Subcategory/{Id}/{CategoryId}")
    public ResponseEntity<Subcategory> subcategoryUpdate(@RequestBody Subcategory subcategory,
                                                         @PathVariable("Id")Long Id,
                                                       @PathVariable("CategoryId")Long CategoryId){
        Subcategory subcategoryResult = subcategoryService.SubcategoryUpdate(subcategory,Id,CategoryId);
        return ResponseEntity.ok().body(subcategoryResult);
    }
}