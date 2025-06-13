package br.com.emodulo.vehicle.adapter.in.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record VehicleRequestDTO (

        @NotBlank(message = "Id do veículo é obrigatório", groups = OnUpdate.class)
        UUID id,

        @NotBlank (message = "Placa do veículo é obrigatório")
        String plate,

        @NotBlank (message = "Cor do veículo é obrigatório")
        String color,

        @Positive(message = "Ano do veículo é obrigatório")
        Integer year,

        @Positive(message = "Quilometragem do veículo é obrigatório")
        Integer mileage,

        @Positive(message = "Id do modelo do veículo é obrigatório")
        Long model_id
) {
}
