package com.example.sena.sistemaVehiculos.service.implementacion;

import com.example.sena.sistemaVehiculos.entity.Conductor;
import com.example.sena.sistemaVehiculos.repository.ConductorRepository;
import com.example.sena.sistemaVehiculos.service.ConductorService;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @SneakyThrows
    @Override
    public Conductor registerConductor(Conductor conductor) {


        if (conductorRepository.existsByLicenciaConductor(conductor.getLicenciaConductor())) {
            throw new BadRequestException("La licencia del conductor ya existe");
        }

        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> listConductor() {
        return conductorRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Conductor updateConductor(Long idConductor, Conductor conductor) {

        Conductor conductorExistente = conductorRepository.findById(idConductor)
                .orElseThrow(() -> new Exception("Conductor ID " + idConductor + " not found"));

        conductorExistente.setNombreConductor(conductor.getNombreConductor());
        conductorExistente.setLicenciaConductor(conductor.getLicenciaConductor());
        conductorExistente.setTelefonoConductor(conductor.getTelefonoConductor());
        conductorExistente.setDireccionConductor(conductor.getDireccionConductor());
        conductorExistente.setEstadoConductor(conductor.getEstadoConductor());
        conductorExistente.setVehiculo(conductor.getVehiculo());

        return conductorRepository.save(conductorExistente);
    }

    @SneakyThrows
    @Override
    public void deleteConductor(Long idConductor) {

        Conductor conductorExistente = conductorRepository.findById(idConductor)
                .orElseThrow(() -> new Exception("Conductor ID " + idConductor + " not found"));

        conductorRepository.deleteById(idConductor);
    }
}

