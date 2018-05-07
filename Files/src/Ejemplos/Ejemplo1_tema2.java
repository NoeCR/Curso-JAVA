package Ejemplos;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejemplo1_tema2 {

	public static void main(String[] args) throws IOException{
	
		FileInputStream f_in = new FileInputStream("./archivos/f1.txt");
		int c = f_in.read();
		while(c !=-1) {
			System.out.print((char)c);
			c = f_in.read();
		}
		f_in.close();
	}	
}
