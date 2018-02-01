package Ejercicios;

import java.util.Scanner;
public class Digitos2 {
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
		int contp=0;
		String palabraActual;
		for (int i=0;i<palabras.length;i++){
			palabraActual = palabras[i];
			for (char ch : palabraActual.toCharArray()) {
				if (Character.isLetter(ch)) {
					break;
    		}
				if(Character.isDigit(ch)){
					contp++;
				}
			}
			if(palabraActual.length()==contp){
			cont++;
			}
			contp=0;
		}
		System.out.println("Cantidad de numeros en cadena es:  " + cont );
	}

}
