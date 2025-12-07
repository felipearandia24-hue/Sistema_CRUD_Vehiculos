package com.example.sena.sistemaVehiculos.service.implementacion;

import com.example.sena.sistemaVehiculos.entity.Seguro;
import com.example.sena.sistemaVehiculos.repository.SeguroRepository;
import com.example.sena.sistemaVehiculos.service.SeguroService;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @SneakyThrows
    @Override
    public Seguro registerCategory(Seguro seguro) {

        // Validación: evitar polizas repetidas
        if (seguroRepository.existsByNumeroPoliza(seguro.getNumeroPoliza())) {
            throw new BadRequestException("El número de póliza ya existe");
        }

        return seguroRepository.save(seguro);
    }

    @Override
    public List<Seguro> listCategory() {
        return seguroRepository.findAll();
    }

    @Override
    public Optional<Seguro> searchCategoryById(Long idSeguro) {
        return seguroRepository.findById(idSeguro);
    }

    @SneakyThrows
    @Override
    public Seguro updateCategory(Long idSeguro, Seguro seguro) {
        Seguro seguroExistente = seguroRepository.findById(idSeguro)
                .orElseThrow(() -> new Exception("El ID del seguro " + idSeguro + " no existe"));

        seguroExistente.setVehiculo(seguro.getVehiculo());
        seguroExistente.setNombreCompania(seguro.getNombreCompania());
        seguroExistente.setNumeroPoliza(seguro.getNumeroPoliza());
        seguroExistente.setFechaInicio(seguro.getFechaInicio());
        seguroExistente.setFechaVencimiento(seguro.getFechaVencimiento());

        return seguroRepository.save(seguroExistente);
    }

    @SneakyThrows
    @Override
    public void deleteCategory(Long idSeguro) {
        Seguro seguroExistente = seguroRepository.findById(idSeguro)
                .orElseThrow(() -> new Exception("El ID del seguro " + idSeguro + " no existe"));

        seguroRepository.deleteById(idSeguro);
    }

    @Override
    public List<Seguro> listSegurosByVehiculo(Long idVehiculo) {
        return seguroRepository.findByVehiculoIdVehiculo(idVehiculo);
    }

}
