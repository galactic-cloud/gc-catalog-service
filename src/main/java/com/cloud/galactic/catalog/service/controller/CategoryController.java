package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.catalog.service.entity.Category;
import com.cloud.galactic.catalog.service.service.CategoryService;
import com.cloud.galactic.openapi.api.CategoryApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public abstract class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<Category> addCategory(Category category){
        categoryService.addCategory(category);
//        return ResponseEntity.ok(category);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Category>> deleteCategoryById(String id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @Override
    public ResponseEntity<List<Category>> getCategoryByName(String name) {
//        List<Category> dsCategory=categoryService.getCategoriesByName(name);
//        return ResponseEntity.ok(dsCategory);
        categoryService.getCategoriesByName(name);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Category> updateCategory(Category category) {
//        Category category1=categoryService.updateCategory(category);
//        return ResponseEntity.ok(category1);
        categoryService.updateCategory(category);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategory(){
//        List<Category> dsCategory=categoryService.getListCategory();
//        return ResponseEntity.ok(dsCategory);
        categoryService.getListCategory();
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Category>> getCategoryById(String id) {
        categoryService.getCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
