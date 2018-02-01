
package Ejercicios;
import java.util.Scanner;
public class Descendente {
	public static Scanner inputValue = new Scanner(System.in);
	
	public static String  ordenDescendente(int val1, int val2) {
		if(val1 < val2) {
			return val2 + "\n" + val1;
		}else {
			return val1 + "\n" + val2;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Introduzca los valores a ordenar.");
		System.out.println(ordenDescendente(inputValue.nextInt(), inputValue.nextInt()));
	}
}
