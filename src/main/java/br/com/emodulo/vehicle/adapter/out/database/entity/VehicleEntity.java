package br.com.emodulo.vehicle.adapter.out.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tb_vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Column(name = "version")
    private String version;

    @Column(name = "yearfabrication")
    private Integer yearFabrication;

    @Column(name = "yearmodel")
    private Integer yearModel;

    @Column(name = "odometer")
    private Integer odometer;

    @Column(name = "color")
    private String color;

    @Column(name = "bodytype")
    private String bodyType;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "isarmored")
    private Boolean isArmored;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "issold")
    private Boolean isSold;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;

    public VehicleEntity(Long id, String version, Integer yearFabrication, Integer yearModel, Integer odometer, String color, String bodyType, String transmission, Boolean isArmored, BigDecimal price, Boolean isSold, ModelEntity model) {
        this.id = id;
        this.version = version;
        this.yearFabrication = yearFabrication;
        this.yearModel = yearModel;
        this.odometer = odometer;
        this.color = color;
        this.bodyType = bodyType;
        this.transmission = transmission;
        this.isArmored = isArmored;
        this.price = price;
        this.isSold = isSold;
        this.model = model;
    }
}
