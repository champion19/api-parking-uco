package com.tutorial.crud.dto.parking;

import com.tutorial.crud.entity.Parqueadero;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link Parqueadero} entity
 */
public class ParkingDto implements Serializable {
    private final int numero_vehiculos;
    private final Date fecha_ingreso;
    private final Date fecha_salida;

    public ParkingDto(int numero_vehiculos, Date fecha_ingreso, Date fecha_salida) {
        this.numero_vehiculos = numero_vehiculos;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }

    public int getNumeroVehiculos() {
        return numero_vehiculos;
    }

    public Date getFechaIngreso() {
        return fecha_ingreso;
    }

    public Date getFechaSalida() {
        return fecha_salida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingDto entity = (ParkingDto) o;
        return Objects.equals(this.numero_vehiculos, entity.numero_vehiculos) &&
                Objects.equals(this.fecha_ingreso, entity.fecha_ingreso) &&
                Objects.equals(this.fecha_salida, entity.fecha_salida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero_vehiculos, fecha_ingreso, fecha_salida);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "numeroVehiculos = " + numero_vehiculos + ", " +
                "fechaIngreso = " + fecha_ingreso + ", " +
                "fechaSalida = " + fecha_salida + ")";
    }
}