package br.com.emodulo.vehicle.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Model {

    private final UUID id;
    private final String name;
    private final Brand brand;
}
