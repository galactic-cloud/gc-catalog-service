package com.cloud.galactic.catalog.service.mapper;

import com.cloud.galactic.catalog.service.entity.Bundle;
import com.cloud.galactic.openapi.model.BundleDto;

public class BundleMapperImpl implements BundleMapper {
    @Override
    public Bundle bundle(BundleDto bundleDto) {
        Bundle bundle= new Bundle();
        bundle.setId(bundleDto.getId());
        bundle.setNameGroup(bundleDto.getNameGroup());
        bundle.setName(bundleDto.getName());
        bundle.setStatus(bundleDto.getStatus());
        return bundle;
    }

    @Override
    public BundleDto bundleDto(Bundle bundle) {
        BundleDto bundleDto= new BundleDto();
        bundleDto.setId(bundle.getId());
        bundleDto.setNameGroup(bundle.getNameGroup());
        bundleDto.setName(bundle.getName());
        bundleDto.setStatus(bundle.getStatus());
        return bundleDto;
    }
}
