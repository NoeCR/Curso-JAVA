package Ejercicios;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio1 {
    public static void rellenaArray(int[] a, int max){
        Random aleatorio = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y (max-1)
        int intAleatorio;
        for (int i = 0; i < a.length; i++){
            a[i] = aleatorio.nextInt(max);
        }
    }
    public static void main(String[] args) {
        int[] array1 = new int[20];
        boolean comp = false;
        int num;
        rellenaArray(array1, 30);
        //Antes de empezar a trabajar con el array lo imprimimos
        System.out.println("Array : "+Arrays.toString(array1));
        System.out.println("Introduce un numero a comparar");
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        num = inputValue.nextInt();

        for(int i =0; i < array1.length; i++){
          if(num == array1[i]){
              comp = true;
              break;
          }
        }
        if(comp == true){
            System.out.println("Coincide");
        }else{
          System.out.println("No coincide");
        }


        //Si el programa modifica el array hay que imprimirlo también al final del mismo
      //  System.out.println("Array Modificado : "+Arrays.toString(array1));
    }
}
