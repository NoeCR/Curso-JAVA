package Ejercicios;

import java.util.Scanner;
public class Ejemplo34{
    public static void main (String argv[]){
    int numero;
    char[] letras={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    Scanner inputValue;
    inputValue = new Scanner(System.in);
    System.out.println("Introduzca los numeros de su DNI: ");
    numero = inputValue.nextInt();
    int op = numero % 23;
    System.out.println("La letra de su DNI es: " + letras[op]);
      System.out.println("DNI completo: " + numero + "-" + letras[op]);

    }
}
