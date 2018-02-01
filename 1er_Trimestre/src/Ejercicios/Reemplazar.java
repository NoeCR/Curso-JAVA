package Ejercicios;

import java.util.Scanner;
import java.io.*;
public class Reemplazar {
    static Scanner inputValue = new Scanner(System.in);
    public static String leerCadena(String mensaje){
        System.out.println(mensaje);
        return inputValue.nextLine();

    }
    public static void main(String[] args)
    {
        String cadena = leerCadena("Introduce una cadena");
        System.out.println("Cadena leída: " + cadena);
        System.out.println("Cadena reemplazada: " + (cadena.replace('f', 'd')));
    }
}
