package br.com.emodulo.vehicle.adapter.out.database.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vehicle_id")
    private UUID id;

    @Column(name = "identification")
    private String identification;
    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;
}
