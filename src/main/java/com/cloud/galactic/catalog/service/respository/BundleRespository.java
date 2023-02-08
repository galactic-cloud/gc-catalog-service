package com.cloud.galactic.catalog.service.respository;

import com.cloud.galactic.catalog.service.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BundleRespository  extends JpaRepository<Bundle, String> {
    List<Bundle> findByNameIgnoreCase(String name);
    List<Bundle> findBundlesByNameGroupIgnoreCase(String nameGroup);
    List<Bundle> findBundlesByStatusIgnoreCase(String status);

}
