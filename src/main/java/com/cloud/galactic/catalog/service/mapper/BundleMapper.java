package com.cloud.galactic.catalog.service.mapper;

import com.cloud.galactic.catalog.service.entity.Bundle;
import com.cloud.galactic.openapi.model.BundleDto;

public interface BundleMapper {

    Bundle bundle(BundleDto bundleDto);
    BundleDto bundleDto(Bundle bundle);

}
