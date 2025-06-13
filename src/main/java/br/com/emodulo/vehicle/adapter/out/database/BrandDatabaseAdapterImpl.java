package br.com.emodulo.vehicle.adapter.out.database;

import br.com.emodulo.vehicle.domain.Brand;
import br.com.emodulo.vehicle.port.out.BrandDatabaseAdapter;

import java.util.List;

public class BrandDatabaseAdapterImpl implements BrandDatabaseAdapter {

    @Override
    public Brand getById(Long id) {
        return null;
    }

    @Override
    public List<Brand> getAll() {
        return List.of();
    }
}
