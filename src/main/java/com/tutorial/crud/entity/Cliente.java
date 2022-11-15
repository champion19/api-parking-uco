package com.tutorial.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String email;
    private String numero;

    public Cliente() {
    }

    public Cliente(String nombre, String email, String numero) {
        this.nombre = nombre;
        this.email = email;
        this.numero = numero;
    }

    @JsonIgnoreProperties({"cliente"})
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "cliente")
    private List<Vehiculo> vehiculos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}