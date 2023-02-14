package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.catalog.service.entity.Category;
import com.cloud.galactic.catalog.service.service.CategoryService;
import com.cloud.galactic.openapi.api.CategoryApi;
import com.cloud.galactic.openapi.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<String> addCategory(CategoryDto categoryDto){

        Category category= modelMapper.map(categoryDto, Category.class);
        categoryService.addCategory(category);
        return ResponseEntity.ok("Thêm thành công");
    }
    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<Category> dsCategory=categoryService.getListCategory();
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
    public ResponseEntity<List<CategoryDto>> getCategoryByCategoryName(String categoryName    ){
        List<Category> dsCategory=categoryService.findByCategoryNameIgnoreCase(categoryName);
        Type listType = new TypeToken<List<CategoryDto>>(){}.getType();
        List<CategoryDto> postDtoList = modelMapper.map(dsCategory,listType);
        return ResponseEntity.ok(postDtoList);
    }
    @Override
    public ResponseEntity<List<CategoryDto>> getCategoryByParentID(Integer parentCategoryId){
        List<Category> dsCategory=categoryService.findByParentCategoryId(parentCategoryId);
        Type listType = new TypeToken<List<CategoryDto>>(){}.getType();
        List<CategoryDto> postDtoList = modelMapper.map(dsCategory,listType);
        return ResponseEntity.ok(postDtoList);
    }

    @Override
    public ResponseEntity<String> updateCategory(CategoryDto category){
        Category category01= modelMapper.map(category, Category.class);
        categoryService.updateCategory(category01);
        return ResponseEntity.ok("Cập nhật thành công");

    }

    @Override
    public ResponseEntity<Object> getCategoryById(Integer id){
        Category category= categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

}