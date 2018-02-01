package practica;
import java.util.Scanner;
public class EsTriangulo {
	static Scanner inputValue = new Scanner(System.in);
	
	public static boolean isTriangulo (int val1, int val2, int val3) {
		
		return val1 <= (val2 + val3)  && val2 <= (val1 + val3) && val3 <= (val1+ val2); 
	}
	public static void main(String[] args) {
		System.out.println("Introduzca las tres longitudes para ormar un triangulo");
		if(isTriangulo(inputValue.nextInt(),inputValue.nextInt(),inputValue.nextInt())) {
			System.out.println("Se puede formar un triangulo");
		}else {
			System.out.println("No se puede formar un triangulo");
		}
	}

}
