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
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Scanner teclado = new Scanner(System.in);

    public static ArrayList<Videoteca> listadoVideotecas = new ArrayList<Videoteca>();

    public static void main( String[] args )
    {
        int opcion;

        opcion = menu();

        while(opcion != 4){
            switch (opcion){
                case 1:
                    opcion1();
                    break;
                case 2:
                    opcion2();
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

    public static int menu(){
        int opcion;

        System.out.println("Escoga una opcion:\n");
        System.out.println("1.- Leer fichero json:\n");
        System.out.println("2.- Mostrar datos:\n");
        System.out.println("3.- Guardar fichero:\n");
        System.out.println("4.- Salir:\n");
        opcion = teclado.nextInt();

        return opcion;
    }
}
