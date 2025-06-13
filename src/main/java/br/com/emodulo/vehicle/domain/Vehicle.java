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
    private final String plate;
    private final String color;
    private final Integer year;
    private final Integer mileage;
    private final Model model;
}
