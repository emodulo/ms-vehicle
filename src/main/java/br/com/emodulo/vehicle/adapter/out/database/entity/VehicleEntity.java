package br.com.emodulo.vehicle.adapter.out.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @Column(name = "yearFabrication")
    private Integer yearFabrication;

    @Column(name = "yearModel")
    private Integer yearModel;

    @Column(name = "Odometer")
    private Integer Odometer;

    @Column(name = "color")
    private String color;

    @Column(name = "bodyType")
    private String bodyType;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "isArmored")
    private Boolean isArmored;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "isSold")
    private Boolean isSold;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;
}
