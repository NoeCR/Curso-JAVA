package practica;
import java.util.Scanner;
public class Potencia {
	static Scanner inputValue = new Scanner(System.in);
	
	public static double calcularPortencia (double numero, int exponente) {
		if(exponente > 0) {
			return numero * calcularPortencia(numero, exponente-1);
		}else {
			return 1;
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Introduzca el numero y su exponente");
		System.out.println(calcularPortencia(inputValue.nextDouble(), inputValue.nextInt()));
		
	}

}
