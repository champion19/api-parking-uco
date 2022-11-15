package com.tutorial.crud.dto.client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ClientDto {

    @NotBlank
    @NotEmpty
    private static String nombre;
    @NotBlank
    @NotEmpty
    private static String email;

    @NotBlank
    @NotEmpty
    private static String numero;

    public ClientDto() {
    }

    public ClientDto(@NotBlank @NotEmpty String nombre, @NotBlank @NotEmpty String email, @NotBlank @NotEmpty String numero) {
        this.nombre = nombre;
        this.email = email;
        this.numero = numero;
    }

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getNumero() {
        return numero;
    }

    public void setNumero(String numeros) {
        this.numero = numeros;
    }
}
