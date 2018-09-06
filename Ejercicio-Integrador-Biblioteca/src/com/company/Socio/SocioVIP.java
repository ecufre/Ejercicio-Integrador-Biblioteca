package com.company.Socio;

public class SocioVIP extends Socio {

    private Integer cuotaMensual;

    public SocioVIP(String nombre, String apellido, Integer id, Integer cuotaMensual) {
        super(nombre, apellido, id);
        this.cuotaMensual = cuotaMensual;
        setMaxRetirados(15);
    }
}
