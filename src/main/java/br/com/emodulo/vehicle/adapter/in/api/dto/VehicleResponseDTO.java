package br.com.emodulo.vehicle.adapter.in.api.dto;

import br.com.emodulo.vehicle.domain.Model;

import java.util.UUID;

public record VehicleResponseDTO(
        UUID id,
        String brand,
        String model,
        String plate,
        String color,
        Integer year,
        Integer mileage
) {
}
