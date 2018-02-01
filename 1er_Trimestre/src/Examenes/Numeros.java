package Examenes;

import java.util.Scanner;
public class Numeros {

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

    public static void main(String[] args)
    {
		String frase = leerCadena("Introduce una frase con números");
		/* Haz aquí tu programa */
		String[] palabras = PartirPalabras(frase);
		String remp="";
		int cont;
			for (int i=0;i<palabras.length;i++) {
				int max = palabras[i].length();
				cont = 0;
				for (char caracter : palabras[i].toCharArray()) {
						if (Character.isLetter(caracter)) {
							break;
						}else{
							cont++;
						}
						if (max <= cont) {
							palabras[i] = remp;
						}
				}
					System.out.print(palabras[i] + " ");
			}
			System.out.println();
    }
}
