package br.com.emodulo.vehicle.domain.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Make {

    private Long id;
    private String name;

    public Make(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
