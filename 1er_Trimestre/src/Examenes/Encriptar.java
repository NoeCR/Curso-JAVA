package Examenes;

import java.util.Scanner;

public class Encriptar {

	static Scanner inputValue = new Scanner(System.in);

	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();

	}

	public static int leerEntero(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextInt();

	}


    public static void main(String[] args){
		String frase = leerCadena("Introduce la frase a encriptar");
		int pos = leerEntero("Introduce la clave de encriptación (número entero)");

		/* Haz aquí tu programa */
		int resta, cuantos;
		int intActual, encriptado;
		String palabra="";

		for (Character charActual: frase.toCharArray()) {
			resta =0;
			cuantos=0;
			System.out.println(charActual);
			if(Character.isDigit(charActual)){
				resta = 48;
				cuantos = 10;
			}
			if(Character.isUpperCase(charActual)){
				resta = 65;
				cuantos = 26;
			}
			if(Character.isLowerCase(charActual)){
				resta = 97;
				cuantos = 26;
			}

			if (resta!=0) {
				intActual = charActual - resta;
				encriptado = ((intActual + pos) % cuantos) + resta;
				palabra = palabra + (char)encriptado;
			}else{
				palabra =  palabra + (char)charActual;
			}
		}
		System.out.println(palabra);
  }
}
