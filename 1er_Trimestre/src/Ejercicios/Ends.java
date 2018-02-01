package Ejercicios;

import java.util.Scanner;
import java.lang.*;

public class Ends {
    static Scanner inputValue = new Scanner(System.in);
    public static String leerCadena(String mensaje){
        System.out.println(mensaje);
        return inputValue.nextLine();

    }
    public static void main(String[] args)
    {
      boolean comp = false;
      String cadena1 = leerCadena("Introduce una cadena");
      String cadena2 = leerCadena("Introduce una cadena");
      comp = cadena1.endsWith(cadena2);
      if(comp == true){
        System.out.println("Las cadenas terminan en: " + cadena2);
      }else{
      System.out.println("No coinciden. ");
    }
    }
}
