package br.com.emodulo.vehicle.adapter.out.database.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "model")
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerEntity manufacturer;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicles;
}
