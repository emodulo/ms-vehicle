package br.com.emodulo.vehicle.port.out;

import br.com.emodulo.vehicle.domain.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleDatabaseAdapter {

    Vehicle addVehicle(Vehicle vehicle);
    Vehicle editVehicle(Vehicle vehicle);
    List<Vehicle> getAll(UUID vehicleId, Boolean isReserved);
}
