package Ejemplos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscrituratxt {
	public static void main(String[] args) throws IOException {
		FileReader f_in = new FileReader("./archivos/f3.txt");
		FileWriter f_out = new FileWriter("./archivos/f3_copy.txt");
		
		char[] buffer = new char[30];
		int c = f_in.read(buffer);
		while(c != -1) {
			f_out.write(buffer, 0, c);
			c = f_in.read(buffer);
		}
		f_in.close();
		f_out.close();
	}
}
