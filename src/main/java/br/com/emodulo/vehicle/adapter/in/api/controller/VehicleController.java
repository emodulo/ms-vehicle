package br.com.emodulo.vehicle.adapter.in.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    public ResponseEntity<?> addVehicle() {

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getVehicle() {

        return ResponseEntity.ok().build();
    }


    public ResponseEntity<?> editVehicle() {

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteVehicle() {

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> listVehicles() {

        return ResponseEntity.ok().build();
    }
}
