package br.com.emodulo.vehicle.adapter.out.database.mapper;

import br.com.emodulo.vehicle.adapter.out.database.entity.MakeEntity;
import br.com.emodulo.vehicle.adapter.out.database.entity.ModelEntity;
import br.com.emodulo.vehicle.adapter.out.database.entity.VehicleEntity;
import br.com.emodulo.vehicle.domain.Make;
import br.com.emodulo.vehicle.domain.Model;
import br.com.emodulo.vehicle.domain.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleEntityMapper {

    public VehicleEntity toEntity(Vehicle domain) {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(domain.getId());
        entity.setVersion(domain.getVersion());
        entity.setYearFabrication(domain.getYearFabrication());
        entity.setYearModel(domain.getYearModel());
        entity.setOdometer(domain.getOdometer());
        entity.setColor(domain.getColor());
        entity.setBodyType(domain.getBodyType());
        entity.setTransmission(domain.getTransmission());
        entity.setIsArmored(domain.getIsArmored());
        entity.setPrice(domain.getPrice());
        entity.setIsSold(domain.getIsSold());
        entity.setModel(
                new ModelEntity(
                        domain.getModel().getId(),
                        domain.getModel().getName(),
                        new MakeEntity (
                                domain.getModel().getMake().getId(),
                                domain.getModel().getMake().getName()
                        )
                )
        );
        return entity;
    }

    public Vehicle toDomain(VehicleEntity entity) {
        return new Vehicle(
                entity.getId(),
                entity.getVersion(),
                entity.getYearFabrication(),
                entity.getYearModel(),
                entity.getOdometer(),
                entity.getColor(),
                entity.getBodyType(),
                entity.getTransmission(),
                entity.getIsArmored(),
                entity.getPrice(),
                entity.getIsSold(),
                new Model(
                        entity.getModel().getId(),
                        entity.getModel().getName(),
                        new Make(
                                entity.getModel().getMake().getId(),
                                entity.getModel().getMake().getName()
                        )
                )
        );
    }
}