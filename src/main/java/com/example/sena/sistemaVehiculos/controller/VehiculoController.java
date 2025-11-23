package com.example.sena.sistemaVehiculos.controller;

import com.example.sena.sistemaVehiculos.entity.Vehiculo;
import com.example.sena.sistemaVehiculos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = vehiculoService.registrarVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVehiculo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Vehiculo>> listarVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @PutMapping("/actualizar/{idVehiculo}")
    public ResponseEntity<?> actualizarVehiculo(@PathVariable Long idVehiculo, @RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo actualizarVehiculo = new Vehiculo();
            actualizarVehiculo.setPlacaVehiculo(vehiculo.getPlacaVehiculo());
            actualizarVehiculo.setMarcaVehiculo(vehiculo.getMarcaVehiculo());
            actualizarVehiculo.setModeloVehiculo(vehiculo.getModeloVehiculo());
            actualizarVehiculo.setAnioVehiculo(vehiculo.getAnioVehiculo());
            actualizarVehiculo.setColorVehiculo(vehiculo.getColorVehiculo());

            Vehiculo vehiculoDB = vehiculoService.actualizarVehiculo(idVehiculo, actualizarVehiculo);
            return ResponseEntity.ok(vehiculoDB);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{idVehiculo}")
    public ResponseEntity<?> eliminarVehiculo(@PathVariable Long idVehiculo) {
        try {
            vehiculoService.eliminarVehiculo(idVehiculo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
