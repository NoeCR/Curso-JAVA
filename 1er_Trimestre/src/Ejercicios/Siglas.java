package Ejercicios;

import java.util.Scanner;
public class Siglas {
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
	public static String siglas(String[] palabras){
		String sigla ="";
		for (int i=0;i<palabras.length;i++) {
			if(Character.isUpperCase(palabras[i].charAt(0))){
				sigla = sigla + palabras[i].charAt(0);
			}
		}
		return sigla;
	}
	public static void main(String[] args){
		String frase = leerCadena("Introduce una frase: ");
		String[] palabras = partirPalabras(frase);
		System.out.println(siglas(palabras));
	}
}
