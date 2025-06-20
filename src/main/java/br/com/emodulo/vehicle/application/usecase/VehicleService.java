package br.com.emodulo.vehicle.application.usecase;

import br.com.emodulo.vehicle.domain.exception.VehicleNotFoundException;
import br.com.emodulo.vehicle.domain.model.Model;
import br.com.emodulo.vehicle.domain.model.Vehicle;
import br.com.emodulo.vehicle.port.in.VehicleUseCasePort;
import br.com.emodulo.vehicle.port.out.ModelRepositoryPort;
import br.com.emodulo.vehicle.port.out.VehicleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
    public Page<Vehicle> listFiltered(Boolean sold, Pageable pageable) {
        if (sold == null) {
            return vehicleRepository.findAll(pageable);
        }
        return vehicleRepository.findByIsSold(sold, pageable);
    }

    @Override
    public Vehicle markAsSold(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with id " + id));

        vehicle.setIsSold(true);

        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        if (!vehicleRepository.existsById(id)) {
                throw new VehicleNotFoundException("Vehicle not found with id " + id);
        }
        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with id " + id));
    }
}