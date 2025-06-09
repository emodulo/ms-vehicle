package br.com.emodulo.vehicle.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Vehicle {

    private final UUID id;
    private final String identification;
    private final String color;
    private final Integer year;
    private final Model model;
}
