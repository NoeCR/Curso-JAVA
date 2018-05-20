package Recopilacion_Ejercicios;

import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo10_t2 {
	public static void main(String[] args) throws IOException{
		
		FileWriter f_out = null;
		String text = "Esto es un array de caracteres con caracteres raros: á ç ñ";
		try {
			f_out = new FileWriter("./archivos/f6_v2.txt");
			for(int i = 0; i < text.length(); i++) {
				f_out.write(text.charAt(i));
			}
		}finally {
			if(f_out != null) f_out.close();
		}
	}
}
