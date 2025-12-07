package com.example.sena.sistemaVehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vehiculo")
    private Long idVehiculo;

    @Column(name = "placa_Vehiculo", nullable = false, length = 100)
    private String placaVehiculo;

    @Column(name = "marca_Vehiculo", nullable = false, length = 100)
    private String marcaVehiculo;

    @Column(name = "modelo_Vehiculo", nullable = false, length = 100)
    private String modeloVehiculo;

    @Column(name = "anio_Vehiculo", nullable = false)
    private Integer anioVehiculo;

    @Column(name = "color_Vehiculo", nullable = false, length = 100)
    private String colorVehiculo;

}
