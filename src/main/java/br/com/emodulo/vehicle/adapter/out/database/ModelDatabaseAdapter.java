package br.com.emodulo.vehicle.adapter.out.database;


import br.com.emodulo.vehicle.adapter.out.database.repository.ModelJpaRepository;
import br.com.emodulo.vehicle.domain.Make;
import br.com.emodulo.vehicle.domain.Model;
import br.com.emodulo.vehicle.port.out.ModelRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ModelDatabaseAdapter implements ModelRepositoryPort {

    private final ModelJpaRepository repository;

    @Override
    public Optional<Model> findById(Long id) {
        return repository.findById(id).map(model -> new Model(
                model.getId(),
                model.getName(),
                new Make(
                        model.getMake().getId(),
                        model.getMake().getName()
                )));
    }
}