package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.client.ClienteDto;
import com.tutorial.crud.entity.Cliente;
import com.tutorial.crud.service.ClienteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClienteController {
    @Autowired
    private ClienteService clientesService;

    @GetMapping()
    public List<Cliente> obtenerUsuarios() {
        return clientesService.obtenerUsuarios();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<?> guardarUsuario(@RequestBody ClienteDto clienteDto) {
        if(StringUtils.isBlank(clienteDto.getNombre()) || StringUtils.isAllEmpty(clienteDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(clienteDto.getEmail()) || StringUtils.isAllEmpty(clienteDto.getEmail()))
            return new ResponseEntity<>(new Mensaje("El correo electrónico es Obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(clienteDto.getNumero()) || StringUtils.isAllEmpty(clienteDto.getNumero()))
            return new ResponseEntity<>(new Mensaje("El campo números es obligatorio"), HttpStatus.BAD_REQUEST);
        Cliente cliente = new Cliente(clienteDto.getNombre(), clienteDto.getEmail(), clienteDto.getNumero());
        clientesService.save(cliente);
        return new ResponseEntity<>(new Mensaje("Cliente creado correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!clientesService.existsById(id))
            return new ResponseEntity(new Mensaje("El cliente con ID "+ id + " no existe"), HttpStatus.NOT_FOUND);
        clientesService.delete(id);
        return new ResponseEntity(new Mensaje("Cliente eliminado satisfactoriamente"), HttpStatus.OK);
    }
}