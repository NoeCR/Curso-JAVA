package Ejemplos;
import java.io.*;
public class Ejemplo5_tema2 {

	public static void main(String[] args) throws IOException{
		
		String text = "Contenido para el fichero. ";
		FileOutputStream f_out = new FileOutputStream("./archivos/f4.txt", true);
		for(int i = 0; i < text.length(); i++) {
			f_out.write(text.charAt(i));
		}
		f_out.close();
	}

}
