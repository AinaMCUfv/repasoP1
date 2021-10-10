package org.example;


import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

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
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            Videoteca v = new Videoteca();

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {

                if(entry.getKey().equals("nombre")){
                    v.setNombreV(entry.getValue().toString());
                }else if(entry.getKey().equals("ubicacion")){
                    v.setUbicacion(entry.getValue().toString());
                }else if(entry.getKey().equals("fecha")){
                    v.setFecha(new Date(entry.getValue().toString()));
                }else if(entry.getKey().equals("peliculas")){
                    ArrayList<Pelicula> listadoPelis = (ArrayList<Pelicula>) entry.getValue();
                    v.addPelicula(listadoPelis);
                }

            }

            listadoVideotecas.add(v);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
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
