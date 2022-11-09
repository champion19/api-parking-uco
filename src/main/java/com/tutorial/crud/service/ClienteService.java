package com.tutorial.crud.service;


import com.tutorial.crud.entity.Cliente;
import com.tutorial.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerUsuarios(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente guardarUsuario(Cliente usuario){
        return clienteRepository.save(usuario);
    }

    public Cliente obtenerPorId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public boolean eliminarUsuario(Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
