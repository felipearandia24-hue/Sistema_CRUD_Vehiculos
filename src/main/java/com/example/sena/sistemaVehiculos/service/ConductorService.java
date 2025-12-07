package com.example.sena.sistemaVehiculos.service;

import com.example.sena.sistemaVehiculos.entity.Conductor;
import com.example.sena.sistemaVehiculos.entity.Seguro;

import java.util.List;
import java.util.Optional;

public interface ConductorService {

    Conductor registerConductor(Conductor conductor);

    List<Conductor> listConductor();

    Conductor updateConductor(Long idConductor, Conductor conductor);

    void deleteConductor(Long idConductor);
}
