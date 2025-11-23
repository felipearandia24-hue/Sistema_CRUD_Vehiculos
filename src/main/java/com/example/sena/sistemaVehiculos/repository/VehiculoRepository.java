package com.example.sena.sistemaVehiculos.repository;

import com.example.sena.sistemaVehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    Optional<Vehiculo> findByIdVehiculo(Long vehiculoId);

}
