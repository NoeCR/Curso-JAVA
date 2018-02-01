package practica;
import java.util.Scanner;
public class Nota {
	public static Scanner inputValue = new Scanner(System.in);
	
	public static void establecerNota(double nota) {
		if(nota<3.0) {
			System.out.println("de 0 a 3 Muy Deficiente.");
		}else if(nota < 5.0) {
			System.out.println("de 3 a 5 Insuficiente");
		}else if(nota < 6.0) {
			System.out.println("de 5 a 6 Suficiente.");
		}else if(nota < 7.0) {
			System.out.println("de 6 a 7 Bien");
		}else if(nota < 9.0) {
			System.out.println("de 7 a 9 Notable");
		}else if(nota <=10) {
			System.out.println("de 9 a 10 Sobresalient");
		}else {
			System.out.println("Nota introducida no valida");
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println("Introduzca la nota");
		establecerNota(inputValue.nextDouble()); 	
	}
}
