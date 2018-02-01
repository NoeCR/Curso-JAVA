package practica;
import java.util.Scanner;
public class MultiplicacionRecursiva {

	static Scanner inputValue = new Scanner(System.in);
	
	public static int calcularMulti(int val1, int val2) {
		if(val2 == 1) {
			return val1;
		}else {
			return val1 + calcularMulti(val1, val2-1);
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Introduce el numero y su multiplicador");
		System.out.println(calcularMulti(inputValue.nextInt(), inputValue.nextInt()));
	}

}
