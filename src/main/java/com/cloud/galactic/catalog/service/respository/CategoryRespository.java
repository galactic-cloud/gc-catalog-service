package com.cloud.galactic.catalog.service.respository;

import com.cloud.galactic.catalog.service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryNameIgnoreCase(String categoryName);
    List<Category> findByParentCategoryId(Integer parentCategoryId);

}
