package com.example.sena.sistemaVehiculos.controller;

import com.example.sena.sistemaVehiculos.entity.Seguro;
import com.example.sena.sistemaVehiculos.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seguros")
public class SeguroController {

    @Autowired
    private  SeguroService seguroService;

    // Crear seguro
    @PostMapping
    public ResponseEntity<Seguro> registerSeguro(@RequestBody Seguro seguro) {
        return ResponseEntity.ok(seguroService.registerCategory(seguro));
    }

    // Listar todos los seguros
    @GetMapping
    public ResponseEntity<List<Seguro>> listSeguros() {
        return ResponseEntity.ok(seguroService.listCategory());
    }

    // Buscar seguro por ID
    @GetMapping("/{idSeguro}")
    public ResponseEntity<Optional<Seguro>> searchSeguroById(@PathVariable Long idSeguro) {
        return ResponseEntity.ok(seguroService.searchCategoryById(idSeguro));
    }

    // Actualizar seguro
    @PutMapping("/{idSeguro}")
    public ResponseEntity<Seguro> updateSeguro(
            @PathVariable Long idSeguro,
            @RequestBody Seguro seguro) {

        return ResponseEntity.ok(seguroService.updateCategory(idSeguro, seguro));
    }

    // Eliminar seguro
    @DeleteMapping("/{idSeguro}")
    public ResponseEntity<String> deleteSeguro(@PathVariable Long idSeguro) {
        seguroService.deleteCategory(idSeguro);
        return ResponseEntity.ok("Seguro eliminado correctamente");
    }

    @GetMapping("/vehiculo/{idVehiculo}")
    public ResponseEntity<List<Seguro>> listSegurosByVehiculo(@PathVariable Long idVehiculo) {
        return ResponseEntity.ok(seguroService.listSegurosByVehiculo(idVehiculo));
    }
}
