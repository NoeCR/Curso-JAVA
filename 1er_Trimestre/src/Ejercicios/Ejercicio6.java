package Ejercicios;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio6 {
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
        int[] array1 = new int[15];    
        rellenaArray(array1, 30);
        //Antes de empezar a trabajar con el array lo imprimimos
        System.out.println("Array1 : "+Arrays.toString(array1));
        int[] array2 = array1.clone();
        System.out.println("Array2 : "+Arrays.toString(array2));
        boolean compare = true; 
        
        for(int i=0; i<array1.length;i++) {
        	if(array1[i] != array2[i]) {
        		compare = false;
        	}
        }
        if(compare == true) {
        	 System.out.println("Los vectores son iguales");
        }else {
        	 System.out.println("Vectores distintos");
        }
    }
}