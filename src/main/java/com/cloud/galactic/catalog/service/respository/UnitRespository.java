package com.cloud.galactic.catalog.service.respository;

import com.cloud.galactic.catalog.service.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UnitRespository extends JpaRepository<Unit, String> {
    List<Unit> findByNameIgnoreCase(String name);
    List<Unit> findByValue(Integer value);

}
