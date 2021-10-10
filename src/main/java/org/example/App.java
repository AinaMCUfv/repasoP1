package org.example;


import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

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
