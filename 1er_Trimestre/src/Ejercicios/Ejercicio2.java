package Ejercicios;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio2 {
	static Scanner inputValue = new Scanner(System.in);
    public static void rellenaArray(int[] a, int max){
        Random aleatorio = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y (max-1)
        int intAleatorio;
        for (int i = 0; i < a.length; i++){
            a[i] = aleatorio.nextInt(max);
        }
    } 
    public static int leerNumero(String mensaje) {
		System.out.println(mensaje);
		return inputValue.nextInt();
	} 
    public static void main(String[] args) {
        int[] array1 = new int[10];    
        rellenaArray(array1, 30);
        //Antes de empezar a trabajar con el array lo imprimimos
        System.out.println("Array : "+Arrays.toString(array1));
        int num = leerNumero("Introduce un valor a eliminar: ")- 1;
        int max = array1.length;
        do
         if(num>array1.length) {
        	System.out.println("Valor de indice incorrrecto"); 
        	num = leerNumero("Introduce un valor a comparar: ");
         }  	
        while(num>array1.length);{
        	int eliminado = array1[num];
        	for(int i=num; i<array1.length-1;i++) {
        		array1[i]= array1[i+1];   		
        	}
        	array1[max-1]= eliminado;
        	System.out.println("Array : "+Arrays.toString(array1));
        }
       
    }
}
