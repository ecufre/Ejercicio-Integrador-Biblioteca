package com.company.Socio;

import com.company.Ejemplar;

import java.util.ArrayList;
import java.util.List;

public class Socio {
    private String nombre;
    private String apellido;
    private Integer id;
    private Integer maxRetirados;
    private List<Ejemplar> ejemplaresRetirados;

    public Socio(String nombre, String apellido, Integer id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.maxRetirados = 3;
        ejemplaresRetirados = new ArrayList<>();
    }

    //GETTER
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getId() {
        return id;
    }

    public List<Ejemplar> getEjemplaresRetirados() {
        return ejemplaresRetirados;
    }
    //SETTER

    protected void setMaxRetirados(Integer maxRetirados) {
        this.maxRetirados = maxRetirados;
    }

    public Boolean tieneCupoDisponible(){
        return ejemplaresRetirados.size() < maxRetirados;
    }

    public void tomarPrestadoUnEjemplar(Ejemplar unEjemplar){
        ejemplaresRetirados.add(unEjemplar);
    }

    public void devolverUnEjemplar(Ejemplar unEjemplar){

        for (int i=0; i<ejemplaresRetirados.size(); i++){
            if(ejemplaresRetirados.get(i).equals(unEjemplar)){
                ejemplaresRetirados.remove(i);
                return;
            }
        }
        System.out.println("Este Ejemplar no es de los que retiraste");
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Socio)obj).getId());
    }
}
