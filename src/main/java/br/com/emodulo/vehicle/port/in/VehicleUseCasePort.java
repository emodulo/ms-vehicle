package br.com.emodulo.vehicle.port.in;

import br.com.emodulo.vehicle.domain.Vehicle;

import java.util.List;

public interface VehicleUseCasePort {
    Vehicle create(Vehicle vehicle);
    Vehicle update(Long id, Vehicle vehicle);
    List<Vehicle> listAvailable();
    List<Vehicle> listSold();
    Vehicle markAsSold(Long id);
}
