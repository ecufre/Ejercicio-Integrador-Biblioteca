package com.company;

import com.company.Socio.Socio;

import java.util.Date;

public class Prestamo {

    private Integer id=0;
    private Ejemplar ejemplar;
    private Socio socio;
    private Date fecha;

    public Prestamo(Ejemplar ejemplar, Socio socio) {

        this.ejemplar = ejemplar;
        this.socio = socio;
        this.fecha = new Date();
        this.id = id++;
    }
}
