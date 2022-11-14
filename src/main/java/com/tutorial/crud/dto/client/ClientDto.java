package com.tutorial.crud.dto.client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ClientDto {

    @NotBlank
    private String nombre;
    @NotBlank
    @NotEmpty
    private String email;

    @NotBlank
    @NotEmpty
    private String numeros;

    public ClientDto() {
    }

    public ClientDto(@NotBlank String nombre, @NotBlank @NotEmpty String email, @NotBlank @NotEmpty String numeros) {
        this.nombre = nombre;
        this.email = email;
        this.numeros = numeros;
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

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }
}
