package com.cloud.galactic.catalog.service.service;

import com.cloud.galactic.catalog.service.entity.Category;
import com.cloud.galactic.catalog.service.respository.CategoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRespository categoryRespository;
    @Override
    public Category addCategory(Category category) {
        return categoryRespository.save(category);
    }

    @Override
    public String deleteCategory(String id) {
        categoryRespository.deleteById(id);
        return "Xoa thanh cong ID"+ id;
    }

    @Override
    public Category updateCategory(Category category) {
        Category category2 = categoryRespository.saveAndFlush(category);
        return category2;
    }

    @Override
    public Category getCategoryById(String id) {
        Category category= categoryRespository.findById(id).get();
        return category;
    }

    @Override
    public List<Category> getListCategory() {
        List<Category> dsCategory= categoryRespository.findAll();
        return dsCategory;
    }

    @Override
    public List<Category> getCategoriesByName(String name) {
        return categoryRespository.findByName(name);
    }
}
