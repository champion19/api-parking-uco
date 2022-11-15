package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.parking.ParkingDto;
import com.tutorial.crud.entity.Parqueadero;
import com.tutorial.crud.service.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@CrossOrigin(origins = "*")
public class ParqueaderoController {
    @Autowired
    private ParqueaderoService parqueaderoService;

    @GetMapping()
    public ResponseEntity<List<Parqueadero>> list(){
        List<Parqueadero> list = parqueaderoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<?> guardarParqueadero(@RequestBody ParkingDto parkingDto) {
        if(parkingDto.getNumeroVehiculos() < 0)
            return new ResponseEntity<>(new Mensaje("El número de vehiculos es obligatorio"), HttpStatus.BAD_REQUEST);
        if(parkingDto.getFechaIngreso() == null)
            return new ResponseEntity<>(new Mensaje("La fecha de ingreso es Obligatorio"), HttpStatus.BAD_REQUEST);
        if(parkingDto.getFechaSalida() == null)
            return new ResponseEntity<>(new Mensaje("La fecha de salida es obligatorio"), HttpStatus.BAD_REQUEST);
        Parqueadero parqueadero = new Parqueadero(parkingDto.getNumeroVehiculos(), parkingDto.getFechaIngreso(), parkingDto.getFechaSalida());
        parqueaderoService.save(parqueadero);
        return new ResponseEntity<>(new Mensaje("Se ha almacenado correctamente la información de la celda"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!parqueaderoService.existsById(id))
            return new ResponseEntity(new Mensaje("El parqueadero con ID "+ id + " no existe"), HttpStatus.NOT_FOUND);
        parqueaderoService.delete(id);
        return new ResponseEntity(new Mensaje("Información del parqueadero eliminado satisfactoriamente"), HttpStatus.OK);
    }
}
