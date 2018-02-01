package Ejercicios;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio3 {
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
        int[] array1 = new int[30];    
        rellenaArray(array1, 30);
        //Antes de empezar a trabajar con el array lo imprimimos
        System.out.println("Array : "+Arrays.toString(array1));
        String acum ="";
        
        for(int i=0; i<array1.length; i++){
        	for(int j=i+1; j<array1.length; j++) {
        		if(array1[i]==array1[j]) {
        			acum = acum  + array1[i] + ", ";
        			break;
        		}
        	}
        }
        System.out.println("Los Valores duplicados de un Array son: " + acum);
       
    }
}