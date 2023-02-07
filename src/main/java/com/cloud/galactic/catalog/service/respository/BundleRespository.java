package com.cloud.galactic.catalog.service.respository;

import com.cloud.galactic.catalog.service.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BundleRespository  extends JpaRepository<Bundle, String> {
    List<Bundle> findByName(String name);
    List<Bundle> findBundlesByNameGroup(String nameGroup);
    List<Bundle> findBundlesByStatus(String status);

}
