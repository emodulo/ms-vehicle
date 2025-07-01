package br.com.emodulo.vehicle.adapter.in.api.controller;

import br.com.emodulo.vehicle.adapter.in.api.config.ApiVersion;
import br.com.emodulo.vehicle.adapter.in.api.dto.ApiResponse;
import br.com.emodulo.vehicle.adapter.in.api.dto.PaginationResponse;
import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleRequestDTO;
import br.com.emodulo.vehicle.adapter.in.api.dto.VehicleResponseDTO;
import br.com.emodulo.vehicle.adapter.in.api.mapper.VehicleDtoMapper;
import br.com.emodulo.vehicle.domain.model.Vehicle;
import br.com.emodulo.vehicle.port.in.VehicleUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Tag(name = "Veículos", description = "Operações com veículos")
@RestController
@RequestMapping(ApiVersion.V1 + "/vehicles")
public class VehicleController {

    private final VehicleUseCasePort service;
    private final VehicleDtoMapper mapper;

    @PostMapping
    @Operation(summary = "Cadastrar veículo", description = "Cadastra novo veículo para venda.")
    public ResponseEntity<VehicleResponseDTO> create(@Valid @RequestBody VehicleRequestDTO dto) {
        Vehicle saved = service.create(mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDTO(saved));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza veículo", description = "Atualiza dados do veículo.")
    public ResponseEntity<VehicleResponseDTO> update(@PathVariable Long id,
                                                     @Valid @RequestBody VehicleRequestDTO dto) {
        Vehicle updated = service.update(id, mapper.toDomain(dto));
        return ResponseEntity.ok(mapper.toResponseDTO(updated));
    }

    @GetMapping
    @Operation(summary = "Lista veículos", description = "Lista veículos com paginação e filtros. Exemplo: /vehicles?sold=true&page=0&size=5&sort=price,asc")
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
    @Operation(summary = "Vender veículo", description = "Marca veículo como vendido.")
    public ResponseEntity<?> markAsSold(@PathVariable Long id) {

        Vehicle vehicle = service.getById(id);

        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }

        Vehicle updated = service.markAsSold(id);
        return ResponseEntity.ok(mapper.toResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove veículo por ID", description = "Remove um veículo cadastrado.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar veículo por ID", description = "Retorna os dados de um veículo específico.")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Vehicle vehicle = service.getById(id);

        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mapper.toResponseDTO(vehicle));
    }
}
