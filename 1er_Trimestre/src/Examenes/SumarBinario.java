package Examenes;

import java.util.Scanner;

public class SumarBinario {

	static Scanner inputValue = new Scanner(System.in);

	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
		return inputValue.nextLine();

	}


    public static void main(String[] args)
    {
		String num1 = leerCadena("Introduce un número binario");
		String num2 = leerCadena("Introduce otro número binario");

		/* Haz aquí tu programa */
		String acum;
		String result ="";
		int uno, dos,acarreo = 0;
		int suma=0;
			if (num1.length() < num2.length()) {
				acum = num1;
				num1 = num2;
				num2 = acum;
			}
			for (int i=num1.length()-1;i>0;i--) {
				uno = num1.charAt(i)-48;
				dos = 0;
				int dif = num1.length() - num2.length();
				if (i-dif > 0){
					dos = num2.charAt(i-dif)-48;
				}
				suma = uno + dos + acarreo;
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
				if (acarreo!=0) {
					result = "1" + result;
				}
			}
			System.out.println(result);
    }

}
