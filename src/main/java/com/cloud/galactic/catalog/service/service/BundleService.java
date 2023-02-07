package com.cloud.galactic.catalog.service.service;

import com.cloud.galactic.catalog.service.entity.Bundle;

import java.util.List;

public interface BundleService {
    public Bundle addBundle(Bundle bundle);
    public String deleteBundle( String id);

    public Bundle updateBundle (Bundle bundle);

    public Bundle getBundleById( String id );

    public List<Bundle> getListBundle();

    public List<Bundle> findBundlesByName(String name);

    public List<Bundle> findBundlesByNameGroup(String nameGroup);

    public List<Bundle> findBundlesByStatus(String status);
}
