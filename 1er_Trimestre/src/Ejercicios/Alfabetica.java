package Ejercicios;

import java.util.Scanner;
public class Alfabetica {
	static Scanner inputValue = new Scanner(System.in);
	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();
	}

	public static void main(String[] args){
		String palabra = leerCadena("Introduce una palabra: ");
		palabra = palabra.toLowerCase();
		boolean alfa = true;
		for (int i=0;i<palabra.length()-1; i++) {
			char caracter = palabra.charAt(i);
			if (caracter>palabra.charAt(i+1)) {
				alfa = false;
				break;
			}
		}
		if (alfa==true) {
			System.out.println("Palabra alfabetica");
		}else{
			System.out.println("La palabra no es alfabetica");
		}

	}
}
