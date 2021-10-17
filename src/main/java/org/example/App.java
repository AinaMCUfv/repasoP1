package org.example;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;


public class App 
{
    public static Scanner teclado = new Scanner(System.in);

    public static ArrayList<Videoteca> listadoVideotecas = new ArrayList<Videoteca>();

    public static void main( String[] args )
    {
        int opcion;

        opcion = menu();

        while(opcion != 5){
            switch (opcion){
                case 1:
                    opcion1();
                    break;
                case 2:
                    opcion2();
                    break;
                case 3:
                    opcion3();
                    break;
                case 4:
                    opcion4();
                    break;
                default:
                    System.out.println("Opcion no valida\n");
                    break;
            }

            opcion = menu();
        }


    }

    public static void opcion1(){
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("peliculas.json"));

            // convert JSON file to map
            //Videoteca v = gson.fromJson(reader, Videoteca.class);
            Type tipoLista = new TypeToken<List<Videoteca>>(){}.getType();
            listadoVideotecas = gson.fromJson(reader, tipoLista);
            //System.out.println(listadoVideotecas);


            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void opcion2(){
        for(int i = 0; i < listadoVideotecas.size(); i++){
            Videoteca v = listadoVideotecas.get(i);
            System.out.println("--------------");
            System.out.println("La videoteca " + v.getNombre() + " se encuentra en " + v.getUbicacion() + " y se fundo en " +
                    v.getFecha());
            for(int j = 0; j < v.getListaPeliculas().size(); j++){
                Pelicula p = v.getListaPeliculas().get(j);
                System.out.println("\tTitulo pelicula: " + p.getTitulo());
                System.out.println("\t\tId pelicula: " + p.getId());
                System.out.println("\t\tEstreno pelicula: " + p.getEstreno());
                System.out.println("\t\tSinopsis pelicula: " + p.getSinopsis());
                System.out.println("\t\tGenero pelicula: " + p.getGenero());
                System.out.println("\t\tImdb pelicula: " + p.getImdb());

                ArrayList<Actor> listaActores = p.getListaActores();
                for(int k = 0; k < listaActores.size(); k++){
                    System.out.println("\t\t\t****");
                    Actor actor = listaActores.get(k);
                    System.out.println("\t\t\tNombre: " + actor.getNombreA());
                    System.out.println("\t\t\tGenero: " + actor.getGenero());
                    System.out.println("\t\t\tLink: " + actor.getLink());
                }


            }

        }
    }

    private static void opcion3(){
        String peliculaAux;
        boolean encontrado = false;
        int i = 0;

        System.out.println("Introduzca el nombre de la pelicula a buscar: ");
        teclado.nextLine();
        peliculaAux = teclado.nextLine();

        while(encontrado != true && i < listadoVideotecas.size()){
            int j = 0;

            while(encontrado != true && j < listadoVideotecas.get(i).getListaPeliculas().size()){
                if(listadoVideotecas.get(i).getListaPeliculas().get(j).getTitulo().equals(peliculaAux)){
                    encontrado = true;
                    System.out.println(listadoVideotecas.get(i).getListaPeliculas().get(j).getListaActores());
                }else{
                    j++;
                }
            }

            if(encontrado == false){
                i++;
            }
        }

        if(encontrado == false){
            System.out.println("Pelicula no encontrada en ninguna videoteca");
        }
    }

    private static void opcion4(){
        String nomVideo;
        String gen;
        int i = 0;
        int j = 0;
        System.out.println("Introduzca el nombre de la pelicula a buscar: ");
        nomVideo = teclado.next();

        for(i= 0; i < listadoVideotecas.size(); i++){
            if(nomVideo.equals(listadoVideotecas.get(i).getNombre())){
                for(j = 0; j< listadoVideotecas.get(i).getListaPeliculas().size(); j++){
                    gen = listadoVideotecas.get(i).getListaPeliculas().get(j).getGenero();
                    System.out.println(gen);
                }

            }
        }
    }

    public static int menu(){
        int opcion;

        System.out.println("Escoga una opcion:\n");
        System.out.println("1.- Leer fichero json:\n");
        System.out.println("2.- Mostrar datos:\n");
        System.out.println("3.- Buscar pelicula y mostrar actores:\n");
        System.out.println("4.- Introduce videoteca y mostrar generos:\n");
        System.out.println("5.- Salir:\n");
        opcion = teclado.nextInt();

        return opcion;
    }
}
