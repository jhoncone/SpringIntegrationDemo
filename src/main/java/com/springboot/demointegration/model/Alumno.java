package com.springboot.demointegration.model;

import java.io.Serializable;

public class Alumno implements Serializable {

    private static final long serialVersionUID=-7408851479146003262L;

    private String nombre;
    private String escuela;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", escuela='" + escuela + '\'' +
                '}';
    }
}
