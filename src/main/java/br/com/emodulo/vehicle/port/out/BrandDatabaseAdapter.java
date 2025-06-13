package br.com.emodulo.vehicle.port.out;

import br.com.emodulo.vehicle.domain.Brand;

import java.util.List;

public interface BrandDatabaseAdapter {

    Brand getById(Long id);
    List<Brand> getAll();
}
