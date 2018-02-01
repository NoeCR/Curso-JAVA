package Ejercicios;

import java.util.Scanner;
import java.io.*;
public class Palabras1 {
    static Scanner inputValue = new Scanner(System.in);
    public static String leerCadena(String mensaje){
        System.out.println(mensaje);
        return inputValue.nextLine();

    }
    public static void main(String[] args)
    {
        int cont=0;
        String cadena = leerCadena("Introduce una cadena");
        cadena = cadena.trim();
        cadena = cadena.replaceAll(" +", " ");
        System.out.println("Numero de palabras: " + cadena.split(" ").length);
        /*for (String retval: cadena.split(" +")) {

           System.out.println(retval);
           cont++;
          }
          */
        //System.out.println("Numero de palabras: " + cadena.split(" +").length);

    }
}
