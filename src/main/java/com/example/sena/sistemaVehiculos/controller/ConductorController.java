package com.example.sena.sistemaVehiculos.controller;

import com.example.sena.sistemaVehiculos.entity.Conductor;
import com.example.sena.sistemaVehiculos.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    // Crear conductor
    @PostMapping("/registrar")
    public ResponseEntity<?> registerConductor(@RequestBody Conductor conductor) {
        Conductor nuevo = conductorService.registerConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // Listar conductores
    @GetMapping
    public ResponseEntity<List<Conductor>> listConductores() {
        return ResponseEntity.ok(conductorService.listConductor());
    }

    // Actualizar conductor
    @PutMapping("/{idConductor}")
    public ResponseEntity<Conductor> updateConductor(
            @PathVariable Long idConductor,
            @RequestBody Conductor conductor) {

        return ResponseEntity.ok(conductorService.updateConductor(idConductor, conductor));
    }

    // Eliminar conductor
    @DeleteMapping("/{idConductor}")
    public ResponseEntity<String> deleteConductor(@PathVariable Long idConductor) {
        conductorService.deleteConductor(idConductor);
        return ResponseEntity.ok("Conductor eliminado correctamente");
    }
}