package br.com.emodulo.vehicle.adapter.out.database;

import br.com.emodulo.vehicle.adapter.out.database.mapper.VehicleEntityMapper;
import br.com.emodulo.vehicle.adapter.out.database.repository.VehicleJpaRepository;
import br.com.emodulo.vehicle.domain.Vehicle;
import br.com.emodulo.vehicle.port.out.VehicleRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


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
    public List<Vehicle> findAllAvailable() {
        return jpaRepository.findByIsSoldFalseOrderByPriceAsc()
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Vehicle> findAllSold() {
        return jpaRepository.findByIsSoldTrueOrderByPriceAsc()
                .stream().map(mapper::toDomain).toList();
    }
}
