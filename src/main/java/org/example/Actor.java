package org.example;

public class Actor {

    private String nombre;
    private String link;
    private int genero;

    public Actor(String nomA, String link, int gen){
        this.nombre = nomA;
        this.link = link;
        this.genero = gen;
    }

    public String getNombreA() {
        return nombre;
    }

    public void setNombreA(String nombreA) {
        this.nombre = nombreA;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "nombreA='" + nombre + '\'' +
                ", link='" + link + '\'' +
                ", genero=" + genero +
                '}';
    }
}
