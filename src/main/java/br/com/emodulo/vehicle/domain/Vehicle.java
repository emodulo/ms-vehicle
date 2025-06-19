package br.com.emodulo.vehicle.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Vehicle {

    private Long id;
    private String version;
    private Integer yearFabrication;
    private Integer yearModel;
    private Integer Odometer;
    private String color;
    private String bodyType;
    private String transmission;
    private Boolean isArmored;
    private BigDecimal price;
    private Boolean isSold;
    private Model model;

    public Vehicle(String version, Integer yearFabrication, Integer yearModel, Integer odometer, String color, String bodyType, String transmission, Boolean isArmored, BigDecimal price, Boolean isSold, Model model) {
        this.version = version;
        this.yearFabrication = yearFabrication;
        this.yearModel = yearModel;
        Odometer = odometer;
        this.color = color;
        this.bodyType = bodyType;
        this.transmission = transmission;
        this.isArmored = isArmored;
        this.price = price;
        this.isSold = isSold;
        this.model = model;
    }

    public Vehicle(Long id, String version, Integer yearFabrication, Integer yearModel, Integer odometer, String color, String bodyType, String transmission, Boolean isArmored, BigDecimal price, Boolean isSold, Model model) {
        this.id = id;
        this.version = version;
        this.yearFabrication = yearFabrication;
        this.yearModel = yearModel;
        Odometer = odometer;
        this.color = color;
        this.bodyType = bodyType;
        this.transmission = transmission;
        this.isArmored = isArmored;
        this.price = price;
        this.isSold = isSold;
        this.model = model;
    }
}
