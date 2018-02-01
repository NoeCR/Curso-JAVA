package Examenes;

import java.util.Random;
import java.util.Scanner;
public class PasswordGenerator {

	static Random aleatorio = new Random(System.currentTimeMillis());

	/*
		Devuelve la cadena s con los caracteres barajados
	*/
	public static String shuffle(String s)
    {

        String shuffledString = "";

        while (s.length() != 0)
        {
            int index = (int) Math.floor(Math.random() * s.length());
            char c = s.charAt(index);
            s = s.substring(0,index)+s.substring(index+1);
            shuffledString += c;
        }

        return shuffledString;

    }

	// Producir nuevo int aleatorio entre min y max-1
	public static int aleatorio(int min , int max){
		int intAleatorio = aleatorio.nextInt((max - min) + 1) + min;
		return intAleatorio;
	}
	public static void main(String[] args){

		int mayusculas = 2;
		int minusculas = 5;
		int digitos = 3;
		int otros = 2;

		/* Haz aquí tu programa */
		int caracteres = 10;

		/* Fin de tu programa */

		//Barajar la contraseña
		//password = shuffle(password);
//
		//System.out.println("La contraseña es: " + password);
	}
}
