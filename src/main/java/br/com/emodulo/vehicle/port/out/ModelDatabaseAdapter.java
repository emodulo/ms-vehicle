package br.com.emodulo.vehicle.port.out;

import br.com.emodulo.vehicle.domain.Model;

import java.util.List;

public interface ModelDatabaseAdapter {

    Model getById(Long id);
    List<Model> getAll();

}
