package br.com.emodulo.vehicle.port.out;

import br.com.emodulo.vehicle.domain.Model;

import java.util.Optional;

public interface ModelRepositoryPort {
    Optional<Model> findById(Long id);
}
