package br.com.emodulo.vehicle.port.out;

import br.com.emodulo.vehicle.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepositoryPort {
    Vehicle save(Vehicle vehicle);
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findAllAvailable();
    List<Vehicle> findAllSold();
    void deleteById(Long id);
    boolean existsById(Long id);
}
