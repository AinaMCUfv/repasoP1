package org.example;

public class Actor {

    private String nombreA;
    private String link;
    private int genero;

    public Actor(String nomA, String link, int gen){
        this.nombreA = nomA;
        this.link = link;
        this.genero = gen;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
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
                "nombreA='" + nombreA + '\'' +
                ", link='" + link + '\'' +
                ", genero=" + genero +
                '}';
    }
}
