package com.tutorial.crud.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Parqueadero {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero_vehiculos;
    private Date fecha_ingreso;
    private Date fecha_salida;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculos;

    public Parqueadero(){

    }

    public Parqueadero(int numeroVehiculos, Date fechaIngreso, Date fechaSalida) {
        this.numero_vehiculos = numeroVehiculos;
        this.fecha_ingreso = fechaIngreso;
        this.fecha_salida = fechaSalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroVehiculos() {
        return numero_vehiculos;
    }

    public void setNumeroVehiculos(int numeroVehiculos) {
        this.numero_vehiculos = numeroVehiculos;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }




















}
