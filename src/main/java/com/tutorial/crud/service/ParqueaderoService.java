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

    public Parqueadero save(Parqueadero parqueadero){
        return parqueaderoRepository.save(parqueadero);
    }

    public void delete(int id){
        parqueaderoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return parqueaderoRepository.existsById(id);
    }
}
