package br.com.emodulo.vehicle.adapter.in.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brand")
@RequiredArgsConstructor
public class BrandController {

    public ResponseEntity<?> getBrand() {

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> listBrand() {

        return ResponseEntity.ok().build();
    }

}
