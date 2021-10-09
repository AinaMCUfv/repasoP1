package org.example;


import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Scanner teclado = new Scanner(System.in);

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
