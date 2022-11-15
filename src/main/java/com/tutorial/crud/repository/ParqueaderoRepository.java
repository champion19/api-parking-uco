package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {
}