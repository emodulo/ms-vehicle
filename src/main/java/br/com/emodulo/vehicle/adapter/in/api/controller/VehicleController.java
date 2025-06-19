package br.com.emodulo.vehicle.adapter.in.api.controller;

import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleRequestDTO;
import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleResponseDTO;
import br.com.emodulo.vehicle.adapter.in.api.mapper.VehicleDtoMapper;
import br.com.emodulo.vehicle.domain.Vehicle;
import br.com.emodulo.vehicle.port.in.VehicleUseCasePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleUseCasePort service;
    private final VehicleDtoMapper mapper;

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> create(@Valid @RequestBody VehicleRequestDTO dto) {
        Vehicle saved = service.create(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> update(@PathVariable Long id,
                                                     @Valid @RequestBody VehicleRequestDTO dto) {
        Vehicle updated = service.update(id, mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDTO(updated));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> listAvailable() {
        List<Vehicle> list = service.listAvailable();
        return ResponseEntity.ok(list.stream().map(mapper::toResponseDTO).toList());
    }

    @GetMapping("/sold")
    public ResponseEntity<List<VehicleResponseDTO>> listSold() {
        List<Vehicle> list = service.listSold();
        return ResponseEntity.ok(list.stream().map(mapper::toResponseDTO).toList());
    }

    @PatchMapping("/{id}/sell")
    public ResponseEntity<VehicleResponseDTO> markAsSold(@PathVariable Long id) {
        Vehicle updated = service.markAsSold(id);
        return ResponseEntity.ok(mapper.toResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
