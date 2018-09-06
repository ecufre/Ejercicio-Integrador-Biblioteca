package com.company;

import com.company.Socio.Socio;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Socio> socios;
    private List<Libro> libros;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.socios = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void prestar(Integer ISBN, Integer numeroDeIdentificacion){
        for (Socio socio: socios) {// busco al Socio
            if (socio.getId().equals(numeroDeIdentificacion)){ // busco al Socio
               if(socio.tieneCupoDisponible()){//Si el socio tiene cupo disponible para retirar un libro
                  for (Libro libro: libros) {// busco al Libro
                       if(libro.getCodigoISBN().equals(ISBN)){// busco al Libro
                           if (libro.tieneEjemplaresDisponibles()){//si el libro tiene Ejemplares Disponibles
                               libro.prestarEjemplar();//Se retira el ejemplar de la biblioteca
                               Ejemplar unEjemplar= libro.prestarEjemplar();
                               socio.tomarPrestadoUnEjemplar(unEjemplar);//Socio toma prestado el libro
                               prestamos.add(unEjemplar,socio);
                               return;
                           }
                       }
                  }
               }

            }
        }


    }

    public void devolver(Ejemplar unEjemplar, Integer numeroDeIdentificacion){
        for (Socio socio: socios) {// busco al Socio
            if (socio.getId().equals(numeroDeIdentificacion)){ // busco al Socio
               for (int i=0; i<socio.getEjemplaresRetirados().size();i++){
                   if (socio.getEjemplaresRetirados().get(i).equals(unEjemplar)){//verifico que el ejemplar entregado es un de los que retiro el usuario
                       for (Libro libro: libros) {// busco al Libro
                           if(libro.getCodigoISBN().equals(unEjemplar.getLibro().getCodigoISBN())){// busco al Libro
                               socio.devolverUnEjemplar(unEjemplar);//El socio devuelve el ejemplar
                               libro.reingresarEjemplar(unEjemplar);//reingreso el ejemplar a la biblioteca
                               return;
                           }
                       }
                   }
               }
            }
        }

    }


    //reacer - se pueden usar los metodos anteriores
    public void prestar(List<Integer> unaListaDeISBN, Integer unNumeroDeIdentificacion){
        for (Socio socio: socios) {// busco al Socio
            if (socio.getId() == unNumeroDeIdentificacion){ // busco al Socio
                for (Integer ISBN: unaListaDeISBN) { //Recorro la lista con los codigos ISBN de los libros
                    if (socio.tieneCupoDisponible()){ //Si el socio tiene cupo disponible para retirar un libro
                        for (Libro libro: libros) {// busco al Libro
                            if(libro.getCodigoISBN().equals(ISBN)){// busco al Libro Comparandolo con el ISBN Actual
                                if (libro.tieneEjemplaresDisponibles()){//si el libro tiene Ejemplares Disponibles
                                    libro.prestarEjemplar();
                                    socio.tomarPrestadoUnEjemplar(libro.prestarEjemplar());//Socio toma prestado el libro
                                    return;
                                }
                            }
                        }
                    }else{
                        return;//el Socio no tiene mas cupo para retirar libros
                    }
                }

            }
        }

    }

    //reacer - se pueden usar los metodos anteriores
    public void devolver(List<Ejemplar> ejemplares, Integer numeroDeIdentificacion){
        for (Socio socio: socios) {// busco al Socio
            if (socio.getId() == numeroDeIdentificacion){ // busco al Socio
                for (Ejemplar unEjemplar: ejemplares) {// Recorro la lista de ejemplares a devolver
                    for (int i=0; i<socio.getEjemplaresRetirados().size();i++){
                        if (socio.getEjemplaresRetirados().get(i).equals(unEjemplar)){//verifico que el ejemplar entregado es un de los que retiro el usuario
                            for (Libro libro: libros) {// busco al Libro
                                if(libro.getCodigoISBN().equals(unEjemplar.getLibro().getCodigoISBN())){// busco al Libro
                                    socio.devolverUnEjemplar(unEjemplar);//El socio devuelve el ejemplar
                                    libro.reingresarEjemplar(unEjemplar);//reingreso el ejemplar a la biblioteca
                                    return;
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
