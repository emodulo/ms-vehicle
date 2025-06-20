package br.com.emodulo.vehicle.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Model {

    private Long id;
    private String name;
    private Make make;

    public Model(Long id, String name, Make make) {
        this.id = id;
        this.name = name;
        this.make = make;
    }
}
