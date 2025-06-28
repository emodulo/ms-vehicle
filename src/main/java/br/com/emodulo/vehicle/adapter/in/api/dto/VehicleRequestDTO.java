package br.com.emodulo.vehicle.adapter.in.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class VehicleRequestDTO {

        @NotBlank
        private String version;

        @NotNull
        @Min(1900)
        private Integer yearFabrication;

        @NotNull
        @Min(1900)
        private Integer yearModel;

        @NotNull
        @Min(0)
        private Integer odometer;

        @NotBlank
        private String color;

        @NotBlank
        private String bodyType;

        @NotBlank
        private String transmission;

        private Boolean isArmored = false;

        @NotNull
        @DecimalMin("0.0")
        private BigDecimal price;

        private Boolean isSold = false;

        @NotNull
        private Long modelId;
}