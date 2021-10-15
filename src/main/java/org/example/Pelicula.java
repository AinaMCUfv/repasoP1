package org.example;

import java.util.ArrayList;

public class Pelicula {
    private int id;
    private int estreno;
    private String titulo;
    private String sinopsis;
    private ArrayList<Actor> reparto = new ArrayList<Actor>();
    private String genero;
    private int imdb;

    public Pelicula(int id, int estr, String tit, String sinop, String gen, int imdb){
        this.id = id;
        this.estreno = estr;
        this.titulo = tit;
        this.sinopsis = sinop;
        this.genero = gen;
        this.imdb = imdb;
    }

    public void addActor(Actor actor){
        reparto.add(actor);
    }

    public ArrayList<Actor> getListaActores() {
        return reparto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getImdb() {
        return imdb;
    }

    public void setImdb(int imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", estreno=" + estreno +
                ", titulo='" + titulo + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", listaActores=" + reparto +
                ", genero='" + genero + '\'' +
                ", imdb=" + imdb +
                '}';
    }
}

