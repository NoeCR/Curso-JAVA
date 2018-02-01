package practica;
import java.util.Scanner;
public class DivisionRecursiva {

	static Scanner inputValue = new Scanner(System.in);
	
	public static int calcularDivi(int val1, int val2) {
		if(val1 < val2) {
			return 0;
		}else {
			return 1 + calcularDivi(val1 - val2, val2);
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Introduce el numero y su multiplicador");
		System.out.println(calcularDivi(inputValue.nextInt(), inputValue.nextInt()));
	}

}