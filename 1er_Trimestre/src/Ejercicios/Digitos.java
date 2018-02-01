package Ejercicios;

import java.util.Scanner;
public class Digitos {
	static Scanner inputValue = new Scanner(System.in);
	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();

	}
	public static String[] partirPalabras (String frase){
		frase = frase.trim();
		frase = frase.replaceAll(" +", " ");
	  return frase.split(" ");

	}
	public static void main(String[] args){
		String frase = leerCadena("Introduce una frase: ");
		String[] palabras = partirPalabras(frase);
		int cont = 0;
		
		
			for (char ch : frase.toCharArray()) {
				if(Character.isDigit(ch)){
					cont++;
				}
			
		}
	System.out.println("Cantidad de digitos en cadena es:  " + cont );
	}
}
/*
		int[] nums = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
		int cont=0;
		for (char caracter : frase.toCharArray()) {
			for (int i=0;i<nums.length;i++) {
				if (caracter==nums[i]) {
						cont++;
				}
			}
		}
*/
