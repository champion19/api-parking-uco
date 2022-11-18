package com.tutorial.crud.service;

import com.tutorial.crud.entity.Cliente;
import com.tutorial.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerUsuarios(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getOne(int id){
        return clienteRepository.findById(id);
    }


    public void delete(int id){
        clienteRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return clienteRepository.existsById(id);
    }
}
