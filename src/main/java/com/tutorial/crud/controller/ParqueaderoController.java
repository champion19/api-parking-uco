package com.tutorial.crud.controller;

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

    @PostMapping()
    public Parqueadero guardarUsuario(@RequestBody Parqueadero parqueadero) {
        return parqueaderoService.guardarParqueadero(parqueadero);
    }

    @GetMapping(path = "/{id}")
    public Parqueadero obtenerParqueaderoPorId(@PathVariable("id") Long id) {
        return parqueaderoService.obtenerPorId(id);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public String eliminarParqueaderoPorId(@PathVariable("id") Long id) {
        boolean ok = this.parqueaderoService.eliminarParqueadero(id);
        if (ok) {
            return "Se eliminó el parqueadero con id " + id;
        } else {
            return "No pudo eliminar el parqueadero con id" + id;
        }
    }
}
