package br.com.emodulo.vehicle.port.in;

import br.com.emodulo.vehicle.domain.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleUseCasePort {
    Vehicle create(Vehicle vehicle);
    Vehicle update(Long id, Vehicle vehicle);
    Page<Vehicle> listFiltered(Boolean sold, Pageable pageable);
    Vehicle markAsSold(Long id);
    void deleteById(Long id);
    Vehicle getById(Long id);
}
