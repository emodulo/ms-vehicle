package br.com.emodulo.vehicle.adapter.out.database;

import br.com.emodulo.vehicle.adapter.out.database.entity.VehicleEntity;
import br.com.emodulo.vehicle.adapter.out.database.mapper.VehicleMapper;
import br.com.emodulo.vehicle.adapter.out.database.repository.VehicleRepository;
import br.com.emodulo.vehicle.domain.Vehicle;
import br.com.emodulo.vehicle.port.out.VehicleDatabaseAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
public class VehicleDatabaseAdapterImpl implements VehicleDatabaseAdapter {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {

        VehicleEntity entity = mapper.fromDomain(vehicle);
        VehicleEntity entityDb = repository.save(entity);


        return null;
    }

    @Override
    public Vehicle editVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public List<Vehicle> getAll(UUID vehicleId, Boolean isReserved) {
        return null;
    }
}
