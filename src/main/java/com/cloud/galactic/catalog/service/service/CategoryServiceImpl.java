package com.cloud.galactic.catalog.service.service;

import com.cloud.galactic.catalog.service.entity.Category;
import com.cloud.galactic.catalog.service.respository.CategoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRespository categoryRespository;
    @Override
    public Category addCategory(Category category) {
        return categoryRespository.save(category);
    }

    @Override
    public String deleteCategory(Integer id) {
        categoryRespository.deleteById(id);
        return "Xóa thành công";

    }

    @Override
    public Category updateCategory(Category category) {
        Category category2 = categoryRespository.saveAndFlush(category);
        return category2;
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category= categoryRespository.getReferenceById(id);
        return  category;

    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> dsCategory= categoryRespository.findAll();
        return dsCategory;
    }

    @Override
    public List<Category> findByCategoryNameIgnoreCase(String categoryName) {
        return categoryRespository.findByCategoryName(categoryName);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRespository.findCategories();
    }


}
