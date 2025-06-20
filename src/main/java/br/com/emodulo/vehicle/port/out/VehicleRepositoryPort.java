package br.com.emodulo.vehicle.port.out;

import br.com.emodulo.vehicle.domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VehicleRepositoryPort {
    Vehicle save(Vehicle vehicle);
    Optional<Vehicle> findById(Long id);
    Page<Vehicle> findAll(Pageable pageable);
    Page<Vehicle> findByIsSold(Boolean sold, Pageable pageable);
    void deleteById(Long id);
    boolean existsById(Long id);
}
