package com.cloud.galactic.catalog.service.service;

import com.cloud.galactic.catalog.service.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);
    public String deleteCategory( Integer id);

    public Category updateCategory (Category category);

    public Category getCategoryById(Integer id );

    public List<Category> getListCategory();
    List<Category> findByCategoryNameIgnoreCase(String categoryName);
    List<Category> findByParentCategoryId(Integer parentCategoryId);
}
