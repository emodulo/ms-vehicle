package br.com.emodulo.vehicle.adapter.in.api.mapper;

import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleRequestDTO;
import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleResponseDTO;
import br.com.emodulo.vehicle.domain.model.Model;
import br.com.emodulo.vehicle.domain.model.Vehicle;
import org.springframework.stereotype.Component;


@Component
public class VehicleDtoMapper {

    public Vehicle toDomain(VehicleRequestDTO dto) {
        Model model = new Model(dto.getModelId(), null, null); // nome e make serão preenchidos no service
        return new Vehicle(
                dto.getVersion(),
                dto.getYearFabrication(),
                dto.getYearModel(),
                dto.getOdometer(),
                dto.getColor(),
                dto.getBodyType(),
                dto.getTransmission(),
                dto.getIsArmored(),
                dto.getPrice(),
                dto.getIsSold(),
                model
        );
    }

    public VehicleResponseDTO toResponseDTO(Vehicle vehicle) {
        String modelName = vehicle.getModel() != null ? vehicle.getModel().getName() : null;
        String makeName = vehicle.getModel() != null && vehicle.getModel().getMake() != null
                ? vehicle.getModel().getMake().getName() : null;

        return new VehicleResponseDTO(
                vehicle.getId(),
                vehicle.getVersion(),
                vehicle.getYearFabrication(),
                vehicle.getYearModel(),
                vehicle.getOdometer(),
                vehicle.getColor(),
                vehicle.getBodyType(),
                vehicle.getTransmission(),
                vehicle.getIsArmored(),
                vehicle.getPrice(),
                vehicle.getIsSold(),
                modelName,
                makeName
        );
    }
}