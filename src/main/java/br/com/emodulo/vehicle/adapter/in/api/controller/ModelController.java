package br.com.emodulo.vehicle.adapter.in.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/model")
@RequiredArgsConstructor
public class ModelController {

    public ResponseEntity<?> addModel() {

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getModel() {

        return ResponseEntity.ok().build();
    }
}
