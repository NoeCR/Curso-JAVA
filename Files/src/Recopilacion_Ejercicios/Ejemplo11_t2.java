package Recopilacion_Ejercicios;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo11_t2 {
	public static void main(String[] args) throws IOException{
		
		PrintStream f_out = new PrintStream(new FileOutputStream("./archivos/f7_v2.txt"));
		
		float a = (float) 5.25;
		String b = "Hola.";
		f_out.print(b);
		f_out.println("�Qu� tal?");
		f_out.println(a + 3);
		f_out.printf("El n�mero %d en hexadecimal es %x", 27,27);
		
		f_out.close();
	}
}
