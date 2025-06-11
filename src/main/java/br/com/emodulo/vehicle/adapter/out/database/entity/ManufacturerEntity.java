package br.com.emodulo.vehicle.adapter.out.database.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "manufacturer")
public class ManufacturerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ModelEntity> models;
}
