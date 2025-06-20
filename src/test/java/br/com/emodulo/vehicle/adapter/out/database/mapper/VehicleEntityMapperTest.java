package br.com.emodulo.vehicle.adapter.out.database.mapper;

import br.com.emodulo.vehicle.adapter.out.database.entity.MakeEntity;
import br.com.emodulo.vehicle.adapter.out.database.entity.ModelEntity;
import br.com.emodulo.vehicle.adapter.out.database.entity.VehicleEntity;
import br.com.emodulo.vehicle.domain.Make;
import br.com.emodulo.vehicle.domain.Model;
import br.com.emodulo.vehicle.domain.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VehicleEntityMapperTest {

    private final VehicleEntityMapper mapper = new VehicleEntityMapper();

    @Test
    void shouldMapEntityToDomain() {
        VehicleEntity entity = new VehicleEntity (
                1L, "1.0 LT", 2023, 2023, 10000, "Preto", "Hatch", "Manual", false, new BigDecimal("70000.00"), false,
                new ModelEntity(1L, "Onix", new MakeEntity(1L, "Chevrolet"))
        );

        Vehicle vehicle = mapper.toDomain(entity);

        assertEquals(entity.getModel().getId(), vehicle.getModel().getId());
        assertEquals(entity.getModel().getName(), vehicle.getModel().getName());
        assertEquals(entity.getModel().getMake().getId(), vehicle.getModel().getMake().getId());
        assertEquals(entity.getModel().getMake().getName(), vehicle.getModel().getMake().getName());

        assertEquals(entity.getId(), vehicle.getId());
        assertEquals(entity.getVersion(), vehicle.getVersion());
        assertEquals(entity.getYearFabrication(), vehicle.getYearFabrication());
        assertEquals(entity.getYearModel(), vehicle.getYearModel());
        assertEquals(entity.getOdometer(), vehicle.getOdometer());
        assertEquals(entity.getColor(), vehicle.getColor());
        assertEquals(entity.getBodyType(), vehicle.getBodyType());
        assertEquals(entity.getTransmission(), vehicle.getTransmission());
        assertEquals(entity.getIsArmored(), vehicle.getIsArmored());
        assertEquals(entity.getPrice(), vehicle.getPrice());
        assertEquals(entity.getIsSold(), vehicle.getIsSold());
    }

    @Test
    void shouldMapDomainToEntity() {
        Vehicle vehicle = new Vehicle(
                1L, "1.0 LT", 2023, 2023, 10000, "Preto", "Hatch", "Manual", false, new BigDecimal("70000.00"), false,
                new Model(1L, "Onix", new Make(1L, "Chevrolet"))
        );

        VehicleEntity entity = mapper.toEntity(vehicle);

        assertEquals(vehicle.getModel().getId(), entity.getModel().getId());
        assertEquals(vehicle.getModel().getName(), entity.getModel().getName());
        assertEquals(vehicle.getModel().getMake().getId(), entity.getModel().getMake().getId());
        assertEquals(vehicle.getModel().getMake().getName(), entity.getModel().getMake().getName());

        assertEquals(vehicle.getId(), entity.getId());
        assertEquals(vehicle.getVersion(), entity.getVersion());
        assertEquals(vehicle.getYearFabrication(), entity.getYearFabrication());
        assertEquals(vehicle.getYearModel(), entity.getYearModel());
        assertEquals(vehicle.getOdometer(), entity.getOdometer());
        assertEquals(vehicle.getColor(), entity.getColor());
        assertEquals(vehicle.getBodyType(), entity.getBodyType());
        assertEquals(vehicle.getTransmission(), entity.getTransmission());
        assertEquals(vehicle.getIsArmored(), entity.getIsArmored());
        assertEquals(vehicle.getPrice(), entity.getPrice());
        assertEquals(vehicle.getIsSold(), entity.getIsSold());
    }
}