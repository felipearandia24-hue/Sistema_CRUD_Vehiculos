package com.example.sena.sistemaVehiculos.repository;

import com.example.sena.sistemaVehiculos.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    boolean existsByLicenciaConductor(String licenciaConductor);
}
