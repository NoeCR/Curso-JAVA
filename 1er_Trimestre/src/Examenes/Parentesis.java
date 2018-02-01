package Examenes;

import java.util.Scanner;
public class Parentesis {

	static Scanner inputValue = new Scanner(System.in);

	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();

	}


    public static void main(String[] args)
    {
		String frase = leerCadena("Introduce una frase ");
		/* Haz aquí tu programa */

		int cont=0;

				for (char caracter: frase.toCharArray()) {
					if(cont==-1){
						break;
					}
					if (caracter=='(') {
						cont++;
					}
					if (caracter==')') {
						cont--;
					}
				}
				if (cont!=0) {
					System.out.println("La cadena no esta parentizada");
				}else{
					System.out.println("La cadena esta parentizada");
				}
    }
}
