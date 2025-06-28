package br.com.emodulo.vehicle.adapter.out.database;

import br.com.emodulo.vehicle.adapter.out.database.mapper.VehicleEntityMapper;
import br.com.emodulo.vehicle.adapter.out.database.repository.VehicleJpaRepository;
import br.com.emodulo.vehicle.domain.model.Vehicle;
import br.com.emodulo.vehicle.port.out.VehicleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class VehicleDatabaseAdapter implements VehicleRepositoryPort {

    private final VehicleJpaRepository jpaRepository;
    private final VehicleEntityMapper mapper;

    @Override
    public Vehicle save(Vehicle vehicle) {
        var entity = mapper.toEntity(vehicle);
        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Vehicle> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable)
                .map(mapper::toDomain);
    }

    @Override
    public Page<Vehicle> findByIsSold(Boolean sold, Pageable pageable) {
        return jpaRepository.findByIsSold(sold, pageable)
                .map(mapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
