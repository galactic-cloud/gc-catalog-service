package com.cloud.galactic.catalog.service.service;




import com.cloud.galactic.catalog.service.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);
    public String deleteCategory( String id);

    public Category updateCategory (Category category);

    public Category getCategoryById( String id );

    public List<Category> getListCategory();

    public List<Category> getCategoriesByName(String name);

}
