package Ejercicios;

import java.util.Scanner;
public class Ejemplo37 {
	  public static void main (String argv[]) {
			int[] numeros = new int[10];
			int up = 0;
			int down = 0;
			Scanner inputValue;
			inputValue = new Scanner(System.in);
			for(int i=0;i<numeros.length;i++){
				System.out.println("Introduzca un valor: ");
				numeros[i]= inputValue.nextInt();
				if(numeros[i]>up){
					up = numeros[i];
				}
				if(numeros[i]<down){
					down = numeros[i];
				}
		  }
			System.out.println("El numero mayor es: " + up);
			System.out.println("El numero menor es: " + down);
		}
}
