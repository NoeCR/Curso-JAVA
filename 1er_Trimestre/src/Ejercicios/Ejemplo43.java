package Ejercicios;

import java.util.Scanner;
public class Ejemplo43 {
	  public static void main (String argv[]) {
			int num =0;
			int mult=0;
			int result=0;
			Scanner inputValue;
			inputValue = new Scanner(System.in);
			System.out.println("introduzca el numero a multiplicar: ");
			num = inputValue.nextInt();
			System.out.println("introduzca el multiplo: ");
			mult = inputValue.nextInt();

			for(int i=0;i<mult;i++){
			 	result = num + result;
			}
			System.out.println(result);
    }
}
