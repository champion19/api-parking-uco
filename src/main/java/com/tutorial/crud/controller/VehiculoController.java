package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.Vehiculo.VehiculoDto;
import com.tutorial.crud.entity.Producto;
import com.tutorial.crud.entity.Vehiculo;
import com.tutorial.crud.service.VehiculoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping()
    public List<Vehiculo> obtenerVehiculo() {
        return vehiculoService.obtenerVehiculo();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
        if (!vehiculoService.existsById(id))
            return new ResponseEntity(new Mensaje("El vehiculo no existe"), HttpStatus.NOT_FOUND);
        Vehiculo vehiculo = vehiculoService.getOne(id).get();
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody VehiculoDto vehiculoDto) {
        if(StringUtils.isBlank(vehiculoDto.getTipo()) || StringUtils.isAllEmpty(vehiculoDto.getTipo()))
            return new ResponseEntity<>(new Mensaje("El tipo de vehiculo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(vehiculoDto.getPlaca()) || StringUtils.isAllEmpty(vehiculoDto.getPlaca()))
            return new ResponseEntity<>(new Mensaje("La placa del vehiculo es Obligatorio"), HttpStatus.BAD_REQUEST);
        Vehiculo vehiculo = new Vehiculo(vehiculoDto.getTipo(), vehiculoDto.getPlaca());
        vehiculoService.save(vehiculo);
        return new ResponseEntity<>(new Mensaje("Se ha registrado correctamente la informacion del vehiculo"), HttpStatus.OK);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!vehiculoService.getOne(id).isPresent())
            return new ResponseEntity(new Mensaje("Este registro no existe"), HttpStatus.NOT_FOUND);
        vehiculoService.delete(id);
        return new ResponseEntity(new Mensaje("Registro del vehiculo eliminado correctamente"), HttpStatus.OK);
    }
}