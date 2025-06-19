package br.com.emodulo.vehicle.application.usecase;

import br.com.emodulo.vehicle.domain.Model;
import br.com.emodulo.vehicle.domain.Vehicle;
import br.com.emodulo.vehicle.port.in.VehicleUseCasePort;
import br.com.emodulo.vehicle.port.out.ModelRepositoryPort;
import br.com.emodulo.vehicle.port.out.VehicleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleService implements VehicleUseCasePort {

    private final VehicleRepositoryPort vehicleRepository;
    private final ModelRepositoryPort modelRepository;

    @Override
    public Vehicle create(Vehicle vehicle) {
        Model model = modelRepository.findById(vehicle.getModel().getId())
                .orElseThrow(() -> new RuntimeException("Model not found"));
        vehicle.setModel(model);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Long id, Vehicle vehicle) {
        vehicle.setId(id);
        return create(vehicle);
    }

    @Override
    public List<Vehicle> listAvailable() {
        return vehicleRepository.findAllAvailable();
    }

    @Override
    public List<Vehicle> listSold() {
        return vehicleRepository.findAllSold();
    }
}