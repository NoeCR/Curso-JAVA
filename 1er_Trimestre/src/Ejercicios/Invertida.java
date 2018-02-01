package Ejercicios;

import java.util.Scanner;
public class Invertida {
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
	public static String invetir (String frase){
		String[] palabras = partirPalabras(frase);
		String invetido =" ";
		String esp = " ";
		for (int i=0;i<palabras.length;i++) {
			invetido = palabras[i] + esp +  invetido;
		}
		return invetido;
	}
	public static void main(String[] args){
		String frase = leerCadena("Introduce una frase: ");

		System.out.println(invetir(frase));
	}
}
