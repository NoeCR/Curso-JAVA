package Examenes;

import java.util.Scanner;
public class Palabras {
	static Scanner inputValue = new Scanner(System.in);
	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();

	}
    public static void main(String[] args){
		String frase = leerCadena("Introduce una frase");
		int cont=0;
			if (frase.charAt(0)!= ' ') {
				cont++;
			}
			for (int i=1;i<frase.length();i++) {
				if (frase.charAt(i)!= ' ' && frase.charAt(i-1)== ' ') {
					cont++;
						System.out.println(cont);
				}
			}
			System.out.println("El numero de palabras es: " + cont);
    }
}
