package Recopilacion_Ejercicios;

import java.io.FileReader;
import java.io.IOException;

public class Ejemplo9_t2 {
	public static void main(String[] args) throws IOException{		
		
		FileReader f_in = new FileReader("./archivos/f3.txt");
		char[] buffer = new char[30];
		int c = f_in.read(buffer);
		while(c != -1) {
			for (int i = 0; i < c; i++)
				System.out.print(buffer[i]);
			System.out.println("");
			c = f_in.read(buffer);
		}
		f_in.close();
	}
}
