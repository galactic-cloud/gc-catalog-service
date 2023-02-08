package com.cloud.galactic.catalog.service.service;

import com.cloud.galactic.catalog.service.entity.Unit;
import com.cloud.galactic.catalog.service.respository.UnitRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRespository unitRespository;
    @Override
    public Unit addUnit(Unit unit) {
        return unitRespository.save(unit);
    }

    @Override
    public String deleteUnit(String id) {
        unitRespository.deleteById(id);
        return "Xoa thanh cong ID"+ id;
    }

    @Override
    public Unit updateUnit(Unit unit) {
        Unit unit2 = unitRespository.saveAndFlush(unit);
        return unit2;
    }

    @Override
    public Unit getUnitById(String id) {
        Unit unit= unitRespository.findById(id).get();
        return unit;
    }

    @Override
    public List<Unit> getListUnit() {
        List<Unit> dsUnit= unitRespository.findAll();
        return dsUnit;
    }

    @Override
    public List<Unit> findUnitsByName(String name) {
        return unitRespository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Unit> findByValue(Integer value) {
        return unitRespository.findByValue(value);
    }


}
