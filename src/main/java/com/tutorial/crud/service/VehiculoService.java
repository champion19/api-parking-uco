package com.tutorial.crud.service;
import com.tutorial.crud.entity.Vehiculo;
import com.tutorial.crud.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class VehiculoService {

    @Autowired
    static
    VehiculoRepository vehiculoRepository;

    public List<Vehiculo> list(){
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> getOne(int id){
        return vehiculoRepository.findById(id);
    }

    public Optional<Vehiculo> getByNombre(String nombre){
        return vehiculoRepository.findByNombre(nombre);
    }

    public static void  save(Vehiculo vehiculo){vehiculoRepository.save(vehiculo);
    }

    public static void delete(int id){
        vehiculoRepository.deleteById(id);
    }

    public static boolean existsById(int id){
        return vehiculoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return vehiculoRepository.existsByNombre(nombre);
    }
}
