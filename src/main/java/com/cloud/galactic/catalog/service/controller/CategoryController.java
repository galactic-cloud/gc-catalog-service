package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.catalog.service.entity.Category;
import com.cloud.galactic.catalog.service.service.CategoryService;
import com.cloud.galactic.openapi.api.CategoriesApi;
import com.cloud.galactic.openapi.model.AddCategoryRequest;
import com.cloud.galactic.openapi.model.CategoryDto;
import com.cloud.galactic.openapi.model.UpdateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoriesApi {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<String> addCategory(AddCategoryRequest category){

        Category category1= modelMapper.map(category, Category.class);
        if (category.getParentCategoryId()==null){
            categoryService.addCategory(category1);
        } else {
            category1.setParentCategoryId(categoryService.getCategoryById(category.getParentCategoryId()));
            categoryService.addCategory(category1);
        }
        return ResponseEntity.ok("Thêm thành công");
    }

    @Override
    public ResponseEntity<Object> getAllCategory(){

        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    @Override
    public  ResponseEntity<List<CategoryDto>> getCategories(){
        List<Category> dsCategory=categoryService.getCategories();
        Type listType = new TypeToken<List<CategoryDto>>(){}.getType();
        List<CategoryDto> postDtoList = modelMapper.map(dsCategory,listType);
        return ResponseEntity.ok(postDtoList);

    }
    @Override
    public ResponseEntity<String> deleteCategoryById(Integer id){
            categoryService.deleteCategory(id);
            return ResponseEntity.ok(" Xóa thành công");
    }

    @Override
    public ResponseEntity<String> updateCategory(UpdateCategoryRequest category){
        Category category01= modelMapper.map(category, Category.class);
        category01.setParentCategoryId(categoryService.getCategoryById(category.getParentCategoryId()));
        categoryService.updateCategory(category01);
        return ResponseEntity.ok("Cập nhật thành công");

    }

    @Override
    public ResponseEntity<Object> getCategoryById(Integer id){
        Category category= categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

}