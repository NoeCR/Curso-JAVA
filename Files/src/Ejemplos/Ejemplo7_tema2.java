package Ejemplos;
import java.io.FileReader;
import java.io.IOException;
public class Ejemplo7_tema2 {

	public static void main(String[] args) throws IOException{
		FileReader f_in = new FileReader ("./archivos/f1.txt");
		int c = f_in.read();
		while( c != -1) {
			System.out.print((char)c);
			c = f_in.read();
		}
		f_in.close();
	}

}
