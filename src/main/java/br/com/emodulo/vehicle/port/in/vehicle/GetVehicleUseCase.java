package br.com.emodulo.vehicle.port.in.vehicle;

import br.com.emodulo.vehicle.domain.Vehicle;

import java.util.Optional;
import java.util.UUID;

public interface GetVehicleUseCase {

    Optional<Vehicle> addVehicle(UUID id);
}
