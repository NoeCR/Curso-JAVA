package Ejemplos;
import java.io.*;

public class Ejemplo4_tema2 {

	public static void main(String[] args) throws IOException{
		
		FileInputStream f_in = new FileInputStream("./archivos/f3.txt");
		byte[] buffer = new byte[30];
		int n = f_in.read(buffer);
		while(n != -1) {
			for (int i=0; i < n; i++) {
				System.out.print((char)buffer[i]);				
			}
			System.out.println("");
			n = f_in.read(buffer);
		}
		f_in.close();
	}

}
