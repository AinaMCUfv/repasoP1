package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Videoteca {
    private String nombre;
    private String ubicacion;
    private ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
    private String fecha;

    public Videoteca(){

    }

    public Videoteca(String nom, String ubi, String fecha){
        this.nombre = nom;
        this.ubicacion = ubi;
        this.fecha = fecha;
    }

    public void addPelicula(ArrayList<Pelicula> pelis){
        peliculas = pelis;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return peliculas;
    }

    public void removePelicula(String tituloBorrar){
        boolean encontrado = false;
        int i = 0;

        while(encontrado != true && i < peliculas.size()){
            if(peliculas.get(i).getTitulo().equals(tituloBorrar)){
                peliculas.remove(i);
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Videoteca{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaPeliculas=" + peliculas +
                ", fecha=" + fecha +
                '}';
    }
}
