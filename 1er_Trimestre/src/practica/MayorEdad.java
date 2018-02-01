package practica;
import java.util.Scanner;

public class MayorEdad {

	public static Scanner inputValue = new Scanner(System.in);
	public static void mayorEdad (int edad) {
		if(edad >=18) {
			System.out.println("Es mayor de edad");
		}else {
			System.out.println("Es menor de edad");
		}
	
	}
	public static boolean isMayorEdad(int edad) {
		if(edad>=18) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println("Introduzca su edad.");
		//mayorEdad(inputValue.nextInt());
		System.out.println("El usuario es mayor de edad = " + isMayorEdad(inputValue.nextInt()));
	}

}
