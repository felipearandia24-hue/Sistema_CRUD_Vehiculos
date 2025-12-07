package com.example.sena.sistemaVehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conductor")
    private Long idConductor;

    @Column(name = "nombre_conductor", nullable = false, length = 100)
    private String nombreConductor;

    @Column(name = "licencia_conductor", nullable = false, length = 100)
    private String licenciaConductor;

    @Column(name = "telefono_conductor", nullable = false, length = 100)
    private String telefonoConductor;

    @Column(name = "direccion_conductor", nullable = false, length = 100)
    private String direccionConductor;

    @Column(name = "estado_conductor", nullable = false)
    private Boolean estadoConductor;

    @OneToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    private Vehiculo vehiculo;

}
