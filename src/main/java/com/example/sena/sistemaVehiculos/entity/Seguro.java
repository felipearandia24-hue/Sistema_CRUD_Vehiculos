package com.example.sena.sistemaVehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Seguro")
    private Long idSeguro;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", referencedColumnName = "id_Vehiculo", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "nombre_Compania", nullable = false, length = 100)
    private String nombreCompania;

    @Column(name = "numero_Poliza", nullable = false, length = 100)
    private String numeroPoliza;

    @Column(name = "fecha_Inicio", nullable = false, length = 100)
    private String fechaInicio;

    @Column(name = "fecha_Vencimiento", nullable = false, length = 100)
    private String fechaVencimiento;
}
