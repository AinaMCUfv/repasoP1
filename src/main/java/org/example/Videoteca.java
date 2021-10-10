package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Videoteca {
    private String nombreV;
    private String ubicacion;
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
    private Date fecha;

    public Videoteca(){

    }

    public Videoteca(String nom, String ubi, Date fecha){
        this.nombreV = nom;
        this.ubicacion = ubi;
        this.fecha = fecha;
    }

    public void addPelicula(ArrayList<Pelicula> pelis){
        listaPeliculas = pelis;
    }

    public void removePelicula(String tituloBorrar){
        boolean encontrado = false;
        int i = 0;

        while(encontrado != true && i < listaPeliculas.size()){
            if(listaPeliculas.get(i).getTitulo().equals(tituloBorrar)){
                listaPeliculas.remove(i);
                encontrado = true;

                System.out.println("Pelicula borrada de la lista");
            }else{
                i++;
            }
        }

        if(encontrado == false){
            System.out.println("Pelicula no encontrada en la lista");
        }
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Videoteca{" +
                "nombreV='" + nombreV + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaPeliculas=" + listaPeliculas +
                ", fecha=" + fecha +
                '}';
    }
}
