package Ejercicios;

import java.util.Scanner;
import java.io.*;
public class Palabras2 {
    static Scanner inputValue = new Scanner(System.in);
    public static String leerCadena(String mensaje){
        System.out.println(mensaje);
        return inputValue.nextLine();

    }
    public static void main(String[] args)
    {
        int cont=0;
        String cadena = leerCadena("Introduce una cadena");
        if(cadena.charAt(0)!= ' '){
            cont++;
        }
        for(int i=0;i<cadena.length()-1;i++){
        //  char palabra = cadena.charAt(i);
        //  System.out.println(palabra);
          if(cadena.charAt(i) == ' ' && (cadena.charAt(i+1))!= ' '){
            cont++;
          }
        }
        System.out.println("Numero de palabras: " + cont);

    }
}
