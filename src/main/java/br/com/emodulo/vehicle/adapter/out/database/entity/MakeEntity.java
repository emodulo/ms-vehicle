package br.com.emodulo.vehicle.adapter.out.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tb_makes")
public class MakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "make_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ModelEntity> models;

    public MakeEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
