package com.tutorial.crud.dto.Vehiculo;

import com.tutorial.crud.entity.Vehiculo;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Vehiculo} entity
 */
public class VehiculoDto implements Serializable {
    private final String tipo;
    private final String placa;

    public VehiculoDto(String tipo, String placa) {
        this.tipo = tipo;
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoDto entity = (VehiculoDto) o;
        return Objects.equals(this.tipo, entity.tipo) &&
                Objects.equals(this.placa, entity.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, placa);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "tipo = " + tipo + ", " +
                "placa = " + placa + ", ";
    }
}