package practica;
import java.util.Scanner;
public class MayorDeTres {
	public static Scanner inputValue = new Scanner(System.in);
	public static int mayorDeTres(int[] valores) {
		int valMax = 0;
		for(int i=0; i<valores.length; i++) {
			if(valores[i]>valMax) {
				valMax= valores[i];
			}
		}
	return valMax;			
	}
	
	public static void main(String[] args) {
		int[] valores = new int[3];
		System.out.println("Introduzca los tres valores a comparar.");
		for(int i = 0; i < valores.length; i++ ) {
			valores[i]= inputValue.nextInt();
		}
		System.out.println("El numero mayor es: " + mayorDeTres(valores));
	}
}
