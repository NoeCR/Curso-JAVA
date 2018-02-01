package Ejercicios;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio8 {
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
        int[] array1 = new int[20];    
        rellenaArray(array1, 2);
        //Antes de empezar a trabajar con el array lo imprimimos
        System.out.println("Array1 : "+Arrays.toString(array1));
        int cont=0;
       
        int max = array1.length-1;
        for(int i=0; i<(array1.length-cont);i++) {
        	if(array1[i]==0) {
        		cont++;
        		for(int j=i; j<(array1.length-1);j++) {
        			array1[j] = array1[j+1];
        		}
        		i--;
        		array1[max] = 0;
        	}       	
        }	
        System.out.println("Array1 : "+Arrays.toString(array1));
    }     
}