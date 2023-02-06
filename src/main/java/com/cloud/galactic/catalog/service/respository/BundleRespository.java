package com.cloud.galactic.catalog.service.respository;

import com.cloud.galactic.catalog.service.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BundleRespository  extends JpaRepository<Bundle, String> {
}
