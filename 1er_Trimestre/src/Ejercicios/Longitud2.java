package Ejercicios;

import java.util.Scanner;
public class Longitud2 {
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
		boolean longsim = false;
		System.out.println(frase);
		System.out.println("Introduce una longitud de texto: ");
		k = inputValue.nextInt();
		//System.out.println(k);

		for (int i=0;i<palabras.length;i++) {
			//System.out.println(palabras[i]);
			if (palabras[i].length() == k) {
				longsim = true;
			}
		}
		if (longsim == true) {
			System.out.println("Alguna palabra tiene una longitud de: " + k + " caracteres.");
		}else{
			System.out.println("Ninguna palabra tiene " + k + " caracteres.");
		}

	}

}
