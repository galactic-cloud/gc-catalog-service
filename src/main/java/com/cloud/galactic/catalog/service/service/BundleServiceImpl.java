package com.cloud.galactic.catalog.service.service;

import com.cloud.galactic.catalog.service.entity.Bundle;
import com.cloud.galactic.catalog.service.respository.BundleRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BundleServiceImpl implements BundleService{

    private final BundleRespository bundleRespository;
    @Override
    public Bundle addBundle(Bundle bundle) {
        return bundleRespository.save(bundle);
    }

    @Override
    public String deleteBundle(String id) {
        bundleRespository.deleteById(id);
        return "Xoa thanh cong ID"+ id;
    }

    @Override
    public Bundle updateBundle(Bundle bundle) {
        Bundle bundle2 = bundleRespository.saveAndFlush(bundle);
        return bundle2;
    }

    @Override
    public Bundle getBundleById(String id) {
        Bundle bundle= bundleRespository.findById(id).get();
        return bundle;
    }

    @Override
    public List<Bundle> getListBundle() {
        List<Bundle> dsBundle= bundleRespository.findAll();
        return dsBundle;
    }

    @Override
    public List<Bundle> getCategoriesByName(String name) {
        return null;
    }

}
