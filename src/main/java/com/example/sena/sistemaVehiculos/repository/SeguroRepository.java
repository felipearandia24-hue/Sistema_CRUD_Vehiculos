package com.example.sena.sistemaVehiculos.repository;

import com.example.sena.sistemaVehiculos.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

    boolean existsByNumeroPoliza(String numeroPoliza);

    List<Seguro> findByVehiculoIdVehiculo(Long idVehiculo);

}
