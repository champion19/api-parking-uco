package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.client.ClientDto;
import com.tutorial.crud.entity.Cliente;
import com.tutorial.crud.entity.Producto;
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
    public ResponseEntity<?> guardarUsuario(@RequestBody ClientDto clientDto) {
        if(StringUtils.isBlank(ClientDto.getNombre()) || StringUtils.isAllEmpty(ClientDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(ClientDto.getEmail()) || StringUtils.isAllEmpty(ClientDto.getEmail()))
            return new ResponseEntity<>(new Mensaje("El correo electrónico es Obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(ClientDto.getNumero()) || StringUtils.isAllEmpty(ClientDto.getNumero()))
            return new ResponseEntity<>(new Mensaje("El campo números es obligatorio"), HttpStatus.BAD_REQUEST);
        Cliente cliente;
        cliente = new Cliente(ClientDto.getNombre(), ClientDto.getEmail(), ClientDto.getNumero());
        clientesService.guardarUsuario(cliente);
        return new ResponseEntity<>(new Mensaje("Cliente creado correctamente"), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public Cliente obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return clientesService.obtenerPorId(id);
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.clientesService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}