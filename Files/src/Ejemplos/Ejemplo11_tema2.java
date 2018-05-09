package Ejemplos;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
	

public class Ejemplo11_tema2 {

	public static void main(String[] args) throws IOException{
		PrintStream f_out = new PrintStream(new FileOutputStream("./archivos/f7.txt"));
		float a = (float) 5.25;
		String b = "Hola.";
		f_out.print(b);
		f_out.println("¿Que tal?");
		f_out.println(a + 3);
		f_out.printf("El numero %d en hexadecimal es: %X", 27,27);
		
		f_out.close();
	}

}
