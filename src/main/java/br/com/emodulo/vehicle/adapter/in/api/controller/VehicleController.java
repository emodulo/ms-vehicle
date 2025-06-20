package br.com.emodulo.vehicle.adapter.in.api.controller;

import br.com.emodulo.vehicle.adapter.in.api.dto.ApiResponse;
import br.com.emodulo.vehicle.adapter.in.api.dto.PaginationResponse;
import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleRequestDTO;
import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleResponseDTO;
import br.com.emodulo.vehicle.adapter.in.api.mapper.VehicleDtoMapper;
import br.com.emodulo.vehicle.domain.Vehicle;
import br.com.emodulo.vehicle.port.in.VehicleUseCasePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<VehicleResponseDTO>> listVehicles(
            @RequestParam(required = false) Boolean sold,
            @PageableDefault(size = 10, sort = "price", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Vehicle> pageResponse = service.listFiltered(sold, pageable);
        Page<VehicleResponseDTO> dtoPage = pageResponse.map(mapper::toResponseDTO);

        return ResponseEntity.ok(new ApiResponse<>(
                dtoPage.getContent(),
                PaginationResponse.fromPage(dtoPage)
        ));
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

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getById(@PathVariable Long id) {
        Vehicle vehicle = service.getById(id);
        return ResponseEntity.ok(mapper.toResponseDTO(vehicle));
    }
}
