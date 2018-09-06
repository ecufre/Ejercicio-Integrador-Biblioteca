package com.company;

public class Ejemplar {
    private Libro libro;
    private Integer numeroEdicion;
    private String ubicacion;

    public Ejemplar(Libro libro, Integer numeroEdicion, String ubicacion) {
        this.libro = libro;
        this.numeroEdicion = numeroEdicion;
        this.ubicacion = ubicacion;
    }

    //GETTERS
    public Libro getLibro() {
        return libro;
    }

    public Integer getNumeroEdicion() {
        return numeroEdicion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public boolean equals(Object obj) {

        Ejemplar unEjemplar = (Ejemplar) obj;
        if (this.libro.equals(unEjemplar.getLibro())) {
            if (this.numeroEdicion.equals(unEjemplar.getNumeroEdicion())) {
                if (this.ubicacion.equals(unEjemplar.getUbicacion())) {
                    return true;
                }
            }
        }
        return false;
    }
}
