package Ejercicios;

import java.util.Scanner;
public class Ejemplo39 {
	  public static void main (String argv[]) {
			char[] comp = {'a','e','i','o','u','A','E','I','O','U'};
			int cont=0;
			Scanner inputValue;
			inputValue = new Scanner(System.in);
			System.out.println("Introduzca el texto: ");
			String texto = inputValue.next();
			for(char palabra : texto.toCharArray()){
				for(int i=0;i<comp.length;i++){
					if(palabra==comp[i])
					cont++;
				}
			}
			System.out.println("Total vocales: " + cont);
    }
}
