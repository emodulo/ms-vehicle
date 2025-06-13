package br.com.emodulo.vehicle.application.service;

import br.com.emodulo.vehicle.domain.Vehicle;
import br.com.emodulo.vehicle.port.in.vehicle.AddVehicleUseCase;
import org.springframework.stereotype.Service;

@Service
public class AddVehicleService implements AddVehicleUseCase {

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return null;
    }
}
