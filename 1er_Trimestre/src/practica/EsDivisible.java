package practica;
import java.util.Scanner;
public class EsDivisible {
	public static Scanner inputValue = new Scanner(System.in);
	
	public static boolean isDivisible(int val1, int val2) {
	
		return val1 % val2 == 0;
		
	}
	public static void main(String[] args) {
		System.out.println("Introduzca el dividendo y el divisor");
		if(isDivisible(inputValue.nextInt(), inputValue.nextInt())) {
			System.out.println("Son divisibles");
		}else {
			System.out.println("No son divisibles");
		}
	}
}
