package Recopilacion_Ejercicios;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo5_t2 {
	public static void main(String[] args) throws IOException{
		String text = "Contenido para el fichero.";
		FileOutputStream f_out = new FileOutputStream("./archivos/f4_v2.txt");
		
		for(int i = 0; i < text.length(); i++) {
			f_out.write(text.charAt(i));
		}
		f_out.close();
	}
}
