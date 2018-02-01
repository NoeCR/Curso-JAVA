package Ejercicios;

import java.util.Scanner;
public class Parentesis {
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
		int cont=0;

		for (char caracterActual :  frase.toCharArray()){
			System.out.println(caracterActual);
			if (cont==-1) {
				break;
			}
			if (caracterActual=='(') {
				cont++;
			}else	if (caracterActual==')') {
				cont--;
			}

		}
		if (cont!=0) {
			System.out.println("La cadena no esta parentizada. ");
		}else {
			System.out.println("La cadena esta parentizada. ");
		}
	}

}
