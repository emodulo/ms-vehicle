package br.com.emodulo.vehicle.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@RequiredArgsConstructor
public class Brand {

    private final UUID id;
    private final String name;
    private final List<Model> models;
}
