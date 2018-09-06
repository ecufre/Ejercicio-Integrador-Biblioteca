package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String nombre;
    private Integer codigoISBN;
    private String autor;
    private List<Ejemplar> ejemplares;

    public Libro(String nombre, Integer codigoISBN, String autor) {
        this.nombre = nombre;
        this.codigoISBN = codigoISBN;
        this.autor = autor;
        ejemplares = new ArrayList<>();
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public Integer getCodigoISBN() {
        return codigoISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void agregarNuevoEjemplar(Ejemplar unEjemplar){
       ejemplares.add(unEjemplar);
    }

    public Boolean tieneEjemplaresDisponibles(){
        return ejemplares.size() > 0;
    }

    public Ejemplar prestarEjemplar(){
        Ejemplar unEjemplar = ejemplares.get(0);
        ejemplares.remove(0);
        return unEjemplar;
    }

    public void reingresarEjemplar(Ejemplar unEjemplar){
        ejemplares.add(unEjemplar);
    }

    @Override
    public boolean equals(Object obj) {
        return this.codigoISBN.equals(((Libro)obj).getCodigoISBN());
    }
}
