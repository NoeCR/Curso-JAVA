package Ejercicios;

import java.util.Scanner;
public class Criptografia {
	static Scanner inputValue = new Scanner(System.in);
	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();
	}
	public static int leerNumero(String mensaje) {
		System.out.println(mensaje);
		return inputValue.nextInt();
	}
	public static String Encriptar (String cadena, int numero){
		int intActual;
		int encriptado;
		String palabraEcriptada= "";
		char charActual;
		int restar;
		int cuantos;
		for(int i=0;i<cadena.length();i++) {
			charActual = cadena.charAt(i);
			restar = 0;
			cuantos = 0;
			if(Character.isUpperCase(charActual)) {
				restar = 65;
				cuantos = 26;
			}else if(Character.isDigit(charActual)) {
				restar = 48;
				cuantos = 10;
			}else if(Character.isLowerCase(charActual)) {
				restar = 97;
				cuantos = 26;
			}

			if(cuantos!=0) {
			intActual = (int) charActual - restar;
			encriptado = ((intActual + numero) % cuantos) + restar;
			palabraEcriptada = palabraEcriptada + (char)encriptado;
			}else {
			palabraEcriptada = palabraEcriptada + charActual;
			}
		}
		return palabraEcriptada;
	}
	public static String Desencriptar (String palabraEcriptada, int numero){
		int intActual;
		int encriptado;
		String palabraDesencriptada= "";
		char charActual;
		int restar;
		int cuantos;
		for(int i=0;i<palabraEcriptada.length();i++) {
			charActual = palabraEcriptada.charAt(i);
			restar = 0;
			cuantos = 0;
			if(Character.isUpperCase(charActual)) {
				restar = 65;
				cuantos = 26;
			}else if(Character.isDigit(charActual)) {
				restar = 48;
				cuantos = 10;
			}else if(Character.isLowerCase(charActual)) {
				restar = 97;
				cuantos = 26;
			}
			if(cuantos!=0) {
			intActual = (int) charActual - restar;
			encriptado = ((((intActual - numero) %cuantos) + cuantos) % cuantos)  + restar;
			palabraDesencriptada = palabraDesencriptada + (char)encriptado;
			}else {
			palabraDesencriptada = palabraDesencriptada + charActual;
			}
		}

		return palabraDesencriptada;
	}


	public static void main(String[] args){
		String cadena = leerCadena("Introduce la frase a encriptar: ");
		int numero = leerNumero("Introduce un valor de encriptacion");
		String cadenaEncriptada = Encriptar(cadena, numero);
		String cadenaDesencriptada = Desencriptar(cadenaEncriptada, numero);
		System.out.println(cadenaEncriptada);
		System.out.println(cadenaDesencriptada);
	}
}
