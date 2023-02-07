package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.catalog.service.entity.Bundle;
import com.cloud.galactic.catalog.service.service.BundleService;
import com.cloud.galactic.openapi.api.BundleApi;
import com.cloud.galactic.openapi.model.BundleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BundelController implements BundleApi {

    private final BundleService bundleService;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<String> addBundle(BundleDto bundleDto){

        Bundle bundle= modelMapper.map(bundleDto, Bundle.class);
        bundleService.addBundle(bundle);
        return ResponseEntity.ok((bundle.getName())+" thêm thành công");
    }
    @Override
    public ResponseEntity<List<BundleDto>> getAllBundle(){
        List<Bundle> dsBundle=bundleService.getListBundle();
        Type listType = new TypeToken<List<BundleDto>>(){}.getType();
        List<BundleDto> postDtoList = modelMapper.map(dsBundle,listType);
        return ResponseEntity.ok(postDtoList);

    }
    @Override
    public ResponseEntity<String> deleteBundleById(String id){
        bundleService.deleteBundle(id);
        return ResponseEntity.ok(" xóa thành công" + id);
    }
    @Override
    public ResponseEntity<List<BundleDto>> getBundleByName(String name){
        List<Bundle> dsBundle=bundleService.findBundlesByName(name);
        Type listType = new TypeToken<List<BundleDto>>(){}.getType();
        List<BundleDto> postDtoList = modelMapper.map(dsBundle,listType);
        return ResponseEntity.ok(postDtoList);
    }

    @Override
    public ResponseEntity<String> updateBundle(BundleDto bundle){
        Bundle bundle01= modelMapper.map(bundle, Bundle.class);
        bundleService.updateBundle(bundle01);
        return ResponseEntity.ok((bundle01.getName())+ " Cập nhật thành công");

    }

    @Override
    public ResponseEntity<Object> getBundleById(String id){
        Bundle bundle= bundleService.getBundleById(id);
        return ResponseEntity.ok(bundle);
    }
    @Override
    public ResponseEntity<List<BundleDto>> getBundleByNameGroup(String nameGroup){
        List<Bundle> dsBundle=bundleService.findBundlesByNameGroup(nameGroup);
        Type listType = new TypeToken<List<BundleDto>>(){}.getType();
        List<BundleDto> postDtoList = modelMapper.map(dsBundle,listType);
        return ResponseEntity.ok(postDtoList);
    }
    @Override
    public ResponseEntity<List<BundleDto>> getBundleByNameStatus(String status){
        List<Bundle> dsBundle=bundleService.findBundlesByStatus(status);
        Type listType = new TypeToken<List<BundleDto>>(){}.getType();
        List<BundleDto> postDtoList = modelMapper.map(dsBundle,listType);
        return ResponseEntity.ok(postDtoList);
    }

}