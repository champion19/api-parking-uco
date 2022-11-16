package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    Optional<Vehiculo> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
