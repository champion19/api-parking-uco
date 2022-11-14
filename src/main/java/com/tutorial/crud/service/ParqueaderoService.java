package com.tutorial.crud.service;

import com.tutorial.crud.entity.Parqueadero;
import com.tutorial.crud.repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParqueaderoService {
    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    public List<Parqueadero> list(){
        return parqueaderoRepository.findAll();
    }

    public Parqueadero guardarParqueadero(Parqueadero parqueadero){
        return parqueaderoRepository.save(parqueadero);
    }

    public Parqueadero obtenerPorId(Long id){
        return parqueaderoRepository.findById(id).orElse(null);
    }

    public boolean eliminarParqueadero(Long id){
        try{
            parqueaderoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
