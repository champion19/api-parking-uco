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
    private static VehiculoRepository vehiculoRepository;

    public List<Vehiculo> list(){
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> getOne(int id){
        return vehiculoRepository.findById(id);
    }

    public static Vehiculo save(Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }


    public static void delete(int id){
        vehiculoRepository.deleteById(id);
    }

    public static boolean existsById(int id){
        return vehiculoRepository.existsById(id);
    }

}
