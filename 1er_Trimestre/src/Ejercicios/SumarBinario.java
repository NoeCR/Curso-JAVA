package Ejercicios;
import java.util.Scanner;
public class SumarBinario {
	static Scanner inputValue = new Scanner(System.in);
	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();
	}
	public static String[] partirPalabras (String frase){
		frase = frase.trim();
		frase = frase.replaceAll(" +", " ");
	  return frase.split(" ");
	}
	public static void main(String[] args){
		
		String primerN = leerCadena("Introduce el primer numero binario: ");
		String segundoN = leerCadena("Introduce el segundo numero binario: ");
		int acarreo = 0;
		String acum ="";
		String result = "";
		int suma;
		int num1, num2;
		
		if	(primerN.length()<segundoN.length()) {
			acum = primerN;
			primerN = segundoN;
			segundoN = acum;
		}	
		int dif = primerN.length() - segundoN.length();
		for (int i=primerN.length()-1; i>=0;i--) {
			num1 = primerN.charAt(i) - 48;
			num2 = 0;
			if(i-dif >=0) {
				num2 = segundoN.charAt(i-dif) - 48;
			}
			suma = num1 + num2 + acarreo;
			switch (suma){
				case 0:
					result = "0" + result;
					break;
				case 1:
					result = "1" + result;
					break;
				case 2:
					result = "0" + result;
					acarreo = 1;
					break;
				case 3:
					result = "1" + result;
					acarreo = 1;
					break;
			}
			
		}		
		System.out.println(result);
	}		
}


	