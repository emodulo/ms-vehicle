package br.com.emodulo.vehicle.application.usecase;

import br.com.emodulo.vehicle.domain.model.Make;
import br.com.emodulo.vehicle.domain.model.Model;
import br.com.emodulo.vehicle.domain.model.Vehicle;
import br.com.emodulo.vehicle.port.out.ModelRepositoryPort;
import br.com.emodulo.vehicle.port.out.VehicleRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    VehicleRepositoryPort vehicleRepository;

    @Mock
    ModelRepositoryPort modelRepository;

    @InjectMocks
    VehicleService service;

    private final Model model = new Model(1L, "Onix", new Make(1L, "Chevrolet"));
    private final Vehicle vehicle = new Vehicle(1L, "1.0 LT", 2023, 2023, 10000, "Preto", "Hatch", "Manual", false, new BigDecimal("70000.00"), false, model);


    @Test
    void shouldCreateVehicle() {
        when(modelRepository.findById(1L)).thenReturn(Optional.of(model));
        when(vehicleRepository.save(any())).thenReturn(vehicle);

        Vehicle result = service.create(vehicle);

        assertEquals(vehicle.getId(), result.getId());
        verify(vehicleRepository).save(any());
    }

    @Test
    void shouldUpdateVehicle() {
        when(modelRepository.findById(1L)).thenReturn(Optional.of(model));
        when(vehicleRepository.save(any())).thenReturn(vehicle);

        Vehicle updated = new Vehicle(null, "1.6 LT", 2022, 2023, 20000, "Branco", "Sedã", "Automática", false, new BigDecimal("85000.00"), false, model);
        Vehicle result = service.update(1L, updated);

        assertEquals(1L, result.getId());
        verify(vehicleRepository).save(any());
    }

    @Test
    void shouldListAllWhenSoldIsNull() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Vehicle> page = new PageImpl<>(List.of(vehicle));

        when(vehicleRepository.findAll(pageable)).thenReturn(page);

        Page<Vehicle> result = service.listFiltered(null, pageable);

        assertEquals(1, result.getContent().size());
        verify(vehicleRepository).findAll(pageable);
    }

    @Test
    void shouldListBySoldTrue() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Vehicle> page = new PageImpl<>(List.of(vehicle));

        when(vehicleRepository.findByIsSold(true, pageable)).thenReturn(page);

        Page<Vehicle> result = service.listFiltered(true, pageable);

        assertEquals(1, result.getContent().size());
        verify(vehicleRepository).findByIsSold(true, pageable);
    }

    @Test
    void shouldMarkVehicleAsSold() {
        Vehicle unsoldVehicle = new Vehicle(1L, "1.0 LT", 2023, 2023, 10000, "Preto", "Hatch", "Manual", false, new BigDecimal("70000.00"), false, model);

        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(unsoldVehicle));
        when(modelRepository.findById(1L)).thenReturn(Optional.of(model));
        when(vehicleRepository.save(any())).thenReturn(vehicle);

        Vehicle result = service.markAsSold(1L);

        assertTrue(result.getIsSold());
        verify(vehicleRepository).save(any());
    }

    @Test
    void shouldDeleteVehicleById() {
        when(vehicleRepository.existsById(1L)).thenReturn(true);
        doNothing().when(vehicleRepository).deleteById(1L);

        service.deleteById(1L);

        verify(vehicleRepository).deleteById(1L);
    }

    @Test
    void shouldGetVehicleById() {
        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(vehicle));

        Vehicle result = service.getById(1L);

        assertEquals(vehicle.getId(), result.getId());
    }

    @Test
    void shouldThrowExceptionWhenNotFound() {
        when(vehicleRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.getById(999L));
    }
}