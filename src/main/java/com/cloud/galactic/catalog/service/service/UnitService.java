package com.cloud.galactic.catalog.service.service;

import com.cloud.galactic.catalog.service.entity.Unit;

import java.util.List;

public interface UnitService {
    public Unit addUnit(Unit unit);
    public String deleteUnit( String id);

    public Unit updateUnit (Unit unit);

    public Unit getUnitById(String id );

    public List<Unit> getListUnit();
    public List<Unit> findUnitsByName(String name);
    public List<Unit> findByValue(Integer value);
}
