package Recopilacion_Ejercicios;

import java.io.StringReader;
import java.io.IOException;

public class Ejemplo8_t2 {
	public static void main(String[] args) throws IOException{
	
		String ent =  "Esto es un array de bytes con caracteres raros: � � �";
		StringReader f_in = new StringReader(ent);
		int c = f_in.read();
		while(c != -1) {
			System.out.print((char) c);
			c = f_in.read();
		}
		f_in.close();
	}
}
