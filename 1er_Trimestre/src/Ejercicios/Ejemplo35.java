package Ejercicios;

import java.util.Scanner;
import java.io.*;
public class Ejemplo35{
    public static void main (String argv[]){
    int numero;
    char[] letras={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    //String nie;
    //char[] nie;
    Scanner inputValue;
    Scanner sc = new Scanner(System.in);
    inputValue = new Scanner(System.in);
    System.out.println("Introduzca la letra de su NIE: ");
    char nie = sc.next().charAt(0);
    System.out.println(nie);
    System.out.println("Introduzca los numeros de su NIE: ");
    numero = inputValue.nextInt();

      if(nie=='X'){
          int op = numero % 23;
          System.out.println("La letra de su DNI es: " + letras[op]);
          System.out.println("DNI completo: "+ nie + numero + "-" + letras[op]);
      }else if(nie=='Y'){
          numero = 1000000 + numero;
          int op = numero % 23;
          System.out.println("La letra de su DNI es: " + letras[op]);
          System.out.println("DNI completo: "+ nie + numero + "-" + letras[op]);
      }else if(nie=='Z'){
        numero = 2000000 + numero;
        int op = numero % 23;
        System.out.println("La letra de su DNI es: " + letras[op]);
        System.out.println("DNI completo: "+ nie + numero + "-" + letras[op]);
      }else{
        System.out.println("Introduzca un NIE Valido. ");
      }

    }
}
