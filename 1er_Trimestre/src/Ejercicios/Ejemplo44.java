package Ejercicios;

import java.util.Scanner;
public class Ejemplo44 {
	  public static void main (String argv[]) {
			int num =0;
			int div=0;
			Scanner inputValue;
			inputValue = new Scanner(System.in);
			System.out.println("introduzca el numero a dividir: ");
			num = inputValue.nextInt();
			System.out.println("introduzca el divisor: ");
			div = inputValue.nextInt();

			for(int i=0;num>=div;i++){
			 	num = num - div;
			}
			System.out.println("El resto es: " + num);
    }
}
