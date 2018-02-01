package Ejercicios;

/*Las funciones que hemos visto de cadenas son
	compareTo()
	compareToIgnoreCase()
	concat()
	contains()
	endsWith()
	replace()
	indexOf()
	lastIndexOf()
	substring()
*/
import java.util.Scanner;
public class Longitud {
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
		int cont =0;
		System.out.println(frase);
		System.out.println("Introduce una longitud de texto: ");
		k = inputValue.nextInt();
		System.out.println(k);

		for (int i=0;i<palabras.length;i++) {
			//System.out.println(palabras[i]);
			if (palabras[i].length() == k) {
				cont++;
			}
		}
		System.out.println("Palabras con longitud igual a :" + k + " = " + cont);

	}

}
