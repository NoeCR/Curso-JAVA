package Examenes;

import java.util.Scanner;
public class Longitud {
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
	public static int leerEntero(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextInt();

	}

    public static void main(String[] args){
		String frase = leerCadena("Introduce una frase");
		String[] palabras = PartirPalabras(frase);
		int num1 = leerEntero("Introduce el primer valor");
		int num2 = leerEntero("Introduce el segundo valor");
		/* Haz aquí tu programa */
		boolean largo = true;
		int acum;

		if (num1 < num2) {
			acum = num1;
			num1 = num2;
			num2 = acum;
		}
		for (int i=0;i<palabras.length;i++) {
			int valor = palabras[i].length();
			System.out.println(valor);
			System.out.println(num1);
			if ((valor < num1) || (valor > num2)) {
				largo = false;
				break;
			}
		}
		if (largo==true) {
			System.out.println("Todas las cadenas tienen esa longitud");
		}else{
			System.out.println("Hay alguna palabra que no tiene esa longitud");
		}
  }
}
