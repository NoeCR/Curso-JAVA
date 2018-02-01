package Ejercicios;

import java.util.Scanner;
public class Longitud3 {
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
		int k = 0;
		int maxLength=0;
		System.out.println(frase);
		System.out.println("Introduce una longitud de texto: ");
		k = inputValue.nextInt();

		for (int i=0;i<palabras.length;i++) {
			//System.out.println(palabras[i]);
			if (palabras[i].length() > maxLength) {
				maxLength = palabras[i].length();
			}
		}
		if (maxLength<k) {
			System.out.println("Todas las cadenas son cortas");
		}else{
			System.out.println("Hay alguna palabra larga");
		}

	}

}
