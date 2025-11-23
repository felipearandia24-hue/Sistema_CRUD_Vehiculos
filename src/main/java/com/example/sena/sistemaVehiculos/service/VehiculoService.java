package com.example.sena.sistemaVehiculos.service;

import com.example.sena.sistemaVehiculos.entity.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VehiculoService {

    Vehiculo registrarVehiculo(Vehiculo vehiculo);  // Crear un vehiculo

    List<Vehiculo> listarVehiculos();   // Listar vehiculos

    Vehiculo actualizarVehiculo(Long idVehiculo, Vehiculo vehiculo);

    void eliminarVehiculo(Long idVehiculo);
}
