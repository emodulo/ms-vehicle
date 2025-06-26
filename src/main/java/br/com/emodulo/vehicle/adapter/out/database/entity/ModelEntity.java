package br.com.emodulo.vehicle.adapter.out.database.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(schema = "vehicle", name = "tb_models")
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "make_id")
    private MakeEntity make;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicles;

    public ModelEntity(Long id, String name, MakeEntity make) {
        this.id = id;
        this.name = name;
        this.make = make;
    }

    public void setBrand(MakeEntity make) {
    }
}
