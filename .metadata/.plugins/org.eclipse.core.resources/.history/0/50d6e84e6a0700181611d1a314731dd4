package practica;
import java.util.Scanner;
public class Positivos {
	public static Scanner inputValue = new Scanner(System.in);

	public static int positivos(int[] numeros) {
		int cont =0;
		int[] positivos = new int[numeros.length];
		for(int i =0; i < numeros.length; i++) {
			if(numeros[i] >=0) {
				cont++;
				positivos[i] = numeros[i];
			}else {
				positivos[i] = 0; 
			}
		}
		//System.out.println("Cantidad de numeros positivos = " + cont);
		return cont;
	}
	
	public static void main(String[] args) {
		System.out.println("¿Cuantos numeros quiere comprobar?");
		int [] numeros = new int[inputValue.nextInt()];
		System.out.println("Introduzca los valores a comproba.");
		for(int i =0; i < numeros.length; i++) {
			numeros[i] =inputValue.nextInt(); 
		}
		System.out.println("cantidad de numeros positivos " + positivos(numeros));
		
	}
	
}
