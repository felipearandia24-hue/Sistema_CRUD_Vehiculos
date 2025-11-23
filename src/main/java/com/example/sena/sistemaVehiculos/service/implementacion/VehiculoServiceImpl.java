package com.example.sena.sistemaVehiculos.service.implementacion;

import com.example.sena.sistemaVehiculos.entity.Vehiculo;
import com.example.sena.sistemaVehiculos.repository.VehiculoRepository;
import com.example.sena.sistemaVehiculos.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Vehiculo actualizarVehiculo(Long idVehiculo, Vehiculo vehiculo) {
        Vehiculo vehiculoExisting = vehiculoRepository.findByIdVehiculo(idVehiculo)
                .orElseThrow(() -> new Exception("Vehicle with ID" + idVehiculo + " not found"));

        vehiculoExisting.setPlacaVehiculo(vehiculo.getPlacaVehiculo());
        vehiculoExisting.setMarcaVehiculo(vehiculo.getMarcaVehiculo());
        vehiculoExisting.setModeloVehiculo(vehiculo.getModeloVehiculo());
        vehiculoExisting.setAnioVehiculo(vehiculo.getAnioVehiculo());
        vehiculoExisting.setColorVehiculo(vehiculo.getColorVehiculo());

        return vehiculoRepository.save(vehiculoExisting);
    }

    @SneakyThrows
    @Override
    public void eliminarVehiculo(Long idVehiculo) {
        vehiculoRepository.findByIdVehiculo(idVehiculo)
                .orElseThrow(() -> new Exception("Vehicle with ID" + idVehiculo + " not found"));

        vehiculoRepository.deleteById(idVehiculo);
    }
}
