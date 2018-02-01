package Ejercicios;

import java.util.Scanner;
public class Pasatiempos {
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
		//frase = frase.toLowerCase();
		char remp ='.';

			for (char caracter : frase.toCharArray()) {
				if ("AEIOUaeiou".indexOf(caracter) != -1){
					System.out.print(remp);
				}else{
					System.out.print(caracter);
				}
			}

			System.out.println("");
  }
}
