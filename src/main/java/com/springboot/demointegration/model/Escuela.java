package com.springboot.demointegration.model;

import java.io.Serializable;

public class Escuela implements Serializable {
    private static final long serialVersionUID=1L;

    private String nombre;
    private String director;
    private String direccion;
    private String cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Escuela{" +
                "nombre='" + nombre + '\'' +
                ", director='" + director + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}
