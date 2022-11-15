package com.tutorial.crud.dto.client;

import com.tutorial.crud.entity.Cliente;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Cliente} entity
 */
public class ClienteDto implements Serializable {
    private final String nombre;
    private final String email;
    private final String numero;

    public ClienteDto(String nombre, String email, String numero) {
        this.nombre = nombre;
        this.email = email;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto entity = (ClienteDto) o;
        return Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.numero, entity.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, email, numero);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nombre = " + nombre + ", " +
                "email = " + email + ", " +
                "numero = " + numero + ")";
    }
}