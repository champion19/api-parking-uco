package com.tutorial.crud.service;


import com.tutorial.crud.entity.Vehiculo;
import com.tutorial.crud.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> obtenerVehiculo(){
        return vehiculoRepository.findAll();
    }

    public Vehiculo save(Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

    public Optional<Vehiculo> getOne(int id){
        return vehiculoRepository.findById(id);
    }


    public void delete(int id){
        vehiculoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return vehiculoRepository.existsById(id);
    }
}
