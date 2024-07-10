package com.conversor.modelos;

import com.google.gson.annotations.SerializedName;

public class Moneda {
    @SerializedName("base_code")
    private String nombre;
    private double valor;

    public Moneda(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
