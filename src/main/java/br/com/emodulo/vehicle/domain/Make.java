package br.com.emodulo.vehicle.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


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
