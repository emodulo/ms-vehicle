package br.com.emodulo.vehicle.adapter.in.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class VehicleResponseDTO {

    private Long id;
    private String version;
    private Integer yearFabrication;
    private Integer yearModel;
    private Integer odometer;
    private String color;
    private String bodyType;
    private String transmission;
    private Boolean isArmored;
    private BigDecimal price;
    private Boolean isSold;
    private String model;
    private String make;
}