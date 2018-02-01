package Ejercicios;

import java.util.Scanner;
public class CompararIgnoreCase {
    static Scanner inputValue = new Scanner(System.in);
    public static String leerCadena(String mensaje){
        System.out.println(mensaje);
        return inputValue.nextLine();

    }
    public static void main(String[] args)
    {
      String cadena1 = leerCadena("Introduce una cadena");
      String cadena2 = leerCadena("Introduce una cadena");
      int num = cadena1.compareToIgnoreCase(cadena2);
      if(num<0){
        System.out.println("Cadena " + cadena2 + " es mayor");
      }else if(num==0){
          System.out.println("Las cadenas son iguales");
      }else{
          System.out.println("Cadena " + cadena1 + " es mayor");
      }
    }
}
