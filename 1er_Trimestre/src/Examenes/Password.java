package Examenes;

import java.util.Scanner;

public class Password {

	static Scanner inputValue = new Scanner(System.in);
	
	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();

	}


    public static void main(String[] args)
    {	
		String password = leerCadena("Introduce una contraseña");
		/* Haz aquí tu programa */

    }

}
