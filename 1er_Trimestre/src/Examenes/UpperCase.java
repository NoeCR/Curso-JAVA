package Examenes;

import java.util.Scanner;
public class UpperCase {

	static Scanner inputValue = new Scanner(System.in);

	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();

	}
	public static String[] PartirPalabras(String frase){
		frase = frase.trim();
		frase = frase.replaceAll(" +", " ");
		return frase.split(" ");
	}

    public static void main(String[] args){
    	/*
		String frase = leerCadena("Introduce una frase");
		/* Haz aquí tu programa *//*
		String[] palabras = PartirPalabras(frase);
		String frasemay;
		char may;
		for (int i=0;i<palabras.length;i++) {
			frasemay = palabras[i];
			System.out.println(frasemay.charAt(0));
			//if (frasemay.charAt(0).isLetter) {
				may = Character.toUpperCase(frasemay.charAt(0));
			}else{
				//may = (char)palabras[i];
			}
			*/
		
	}
}
