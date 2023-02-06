package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.catalog.service.entity.Bundle;
import com.cloud.galactic.catalog.service.mapper.BundleMapper;
import com.cloud.galactic.catalog.service.service.BundleService;
import com.cloud.galactic.openapi.api.BundleApi;
import com.cloud.galactic.openapi.model.BundleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public abstract class BundelController implements BundleApi {

    private final BundleService bundleService;
    private final BundleMapper bundleMapper;

    @Override
    public ResponseEntity<String> addBundle(BundleDto bundleDto){
        Bundle bundle1= bundleMapper.bundle(bundleDto);
        bundleService.addBundle(bundle1);
        return ResponseEntity.ok((bundle1.getName())+"is added");
    }

//    @Override
//    public ResponseEntity<List<BundleDto>> getAllBundle(){
//        BundleDto bundleDto= new BundleDto();
//        Bundle bundle= bundleMapper.bundle(bundleDto);
//        List<Bundle> dsBundle= bundleService.getListBundle();
//        List<BundleDto> dsList= new ArrayList<>();
//        dsList.add(new BundleDto().id(bundle.getId()).nameGroup(bundle.getNameGroup()).name(bundle.getName()).status(bundle.getStatus()));
//        return ResponseEntity.ok(dsList);
       
//        List<Bundle> dsBundle=bundleService.getListBundle();
//////        return ResponseEntity.ok(dsBundle);

//    }
//
//    @Override
//    public ResponseEntity<List<Bundle>> deleteBundleById(String id) {
//        bundleService.deleteBundle(id);
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//
//    }
//
//    @Override
//    public ResponseEntity<List<Bundle>> getBundleByName(String name) {
////        List<Bundle> dsBundle=bundleService.getCategoriesByName(name);
////        return ResponseEntity.ok(dsBundle);
//        bundleService.getCategoriesByName(name);
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    @Override
//    public ResponseEntity<Bundle> updateBundle(Bundle bundle) {
////        Bundle bundle1=bundleService.updateBundle(bundle);
////        return ResponseEntity.ok(bundle1);
//        bundleService.updateBundle(bundle);
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    @Override
//    public ResponseEntity<List<Bundle>> getAllBundle(){
////        List<Bundle> dsBundle=bundleService.getListBundle();
////        return ResponseEntity.ok(dsBundle);
//        bundleService.getListBundle();
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }
//
//    @Override
//    public ResponseEntity<List<Bundle>> getBundleById(String id) {
//        bundleService.getBundleById(id);
//        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//    }

}