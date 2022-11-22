package com.tutorial.crud.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Vehiculo {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String placa;
    private String tipo;

    @JsonIgnoreProperties({"vehiculos"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;



    public Vehiculo(){

    }

    public Vehiculo(String tipo, String placa, Cliente cliente) {
        this.tipo = tipo;
        this.placa = placa;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getUsuario() {
        return cliente;
    }

    public void setUsuario(Cliente cliente) {
        this.cliente = cliente;
    }
}
