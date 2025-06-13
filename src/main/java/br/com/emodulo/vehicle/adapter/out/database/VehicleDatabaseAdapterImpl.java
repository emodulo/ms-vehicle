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
    public Vehicle addVehicle(Vehicle vehicle) throws Exception {
        try {

            VehicleEntity entity = mapper.toEntity(vehicle);
            return mapper.toDomain(repository.save(entity));

        } catch (Exception exception) {
            throw new Exception(exception.getMessage(), exception);
        }

    }

    @Override
    public Vehicle editVehicle(Vehicle vehicle) throws Exception {
        try{

            var vehicleDb = repository.findById(vehicle.getId());
            if(vehicleDb.isEmpty()) {
                throw new IllegalArgumentException("Vehicle not found");
            }

            var vehicleEntity = mapper.toEntity(vehicle);
            vehicleEntity = repository.save(vehicleEntity);

            return mapper.toDomain(vehicleEntity);

        } catch (Exception exception) {
            throw new Exception(exception.getMessage(), exception);
        }
    }

    @Override
    public List<Vehicle> getAll(UUID vehicleId, Boolean isReserved) {
        return null;
    }
}
