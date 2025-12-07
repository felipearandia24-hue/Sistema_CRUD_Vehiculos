package com.example.sena.sistemaVehiculos.service;

import com.example.sena.sistemaVehiculos.entity.Seguro;

import java.util.List;
import java.util.Optional;

public interface SeguroService {


    Seguro registerCategory(Seguro seguro);

    List<Seguro> listCategory();

    List<Seguro> listSegurosByVehiculo(Long idVehiculo);

    Optional<Seguro> searchCategoryById(Long idSeguro);

    Seguro updateCategory(Long idSeguro, Seguro seguro);

    void deleteCategory(Long idSeguro);
}
