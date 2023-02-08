package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.catalog.service.entity.Unit;
import com.cloud.galactic.catalog.service.service.UnitService;
import com.cloud.galactic.openapi.api.UnitApi;
import com.cloud.galactic.openapi.model.UnitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UnitController implements UnitApi {

    private final UnitService unitService;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<String> addUnit(UnitDto unitDto){

        Unit unit= modelMapper.map(unitDto, Unit.class);
        unitService.addUnit(unit);
        return ResponseEntity.ok((unit.getName())+" thêm thành công");
    }
    @Override
    public ResponseEntity<List<UnitDto>> getAllUnit(){
        List<Unit> dsUnit=unitService.getListUnit();
        Type listType = new TypeToken<List<UnitDto>>(){}.getType();
        List<UnitDto> postDtoList = modelMapper.map(dsUnit,listType);
        return ResponseEntity.ok(postDtoList);

    }
    @Override
    public ResponseEntity<String> deleteUnitById(String id){
        unitService.deleteUnit(id);
        return ResponseEntity.ok(" xóa thành công" + id);
    }
    @Override
    public ResponseEntity<List<UnitDto>> getUnitByName(String name){
        List<Unit> dsUnit=unitService.findUnitsByName(name);
        Type listType = new TypeToken<List<UnitDto>>(){}.getType();
        List<UnitDto> postDtoList = modelMapper.map(dsUnit,listType);
        return ResponseEntity.ok(postDtoList);
    }

    @Override
    public ResponseEntity<String> updateUnit(UnitDto unit){
        Unit unit01= modelMapper.map(unit, Unit.class);
        unitService.updateUnit(unit01);
        return ResponseEntity.ok((unit01.getName())+ " Cập nhật thành công");

    }

    @Override
    public ResponseEntity<Object> getUnitById(String id){
        Unit unit= unitService.getUnitById(id);
        return ResponseEntity.ok(unit);
    }
    @Override
    public ResponseEntity<List<UnitDto>> getUnitByValue(Integer value){
        List<Unit> dsUnit=unitService.findByValue(value);
        Type listType = new TypeToken<List<UnitDto>>(){}.getType();
        List<UnitDto> postDtoList = modelMapper.map(dsUnit,listType);
        return ResponseEntity.ok(postDtoList);
    }

}