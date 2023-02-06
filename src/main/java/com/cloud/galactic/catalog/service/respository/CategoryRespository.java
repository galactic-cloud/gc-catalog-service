package com.cloud.galactic.catalog.service.respository;

import com.cloud.galactic.catalog.service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer> {
    @Query("select distinct p from Category p " +
            "left join fetch p.parentCategoryId pp " +
            "left join fetch p.subCategory ch " +
            "where pp is null")
    List<Category> findAll();
    
    List<Category> findByCategoryName(String categoryName);
    @Query(value = "select * from category", nativeQuery = true)
    List<Category> findCategories();

}
