package br.com.emodulo.vehicle.adapter.out.database.mapper;

import br.com.emodulo.vehicle.adapter.out.database.entity.VehicleEntity;
import br.com.emodulo.vehicle.domain.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends Mappable<VehicleEntity, Vehicle> {
}
