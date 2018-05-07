package Ejemplos;
import java.io.*;

public class Ejemplo6_tema2 {

	public static void main(String[] args) throws IOException{
		FileInputStream f_in = new FileInputStream("./archivos/f3.txt");
		FileOutputStream f_out = new FileOutputStream("./archivos/f5.txt");
		
		byte[] buffer = new byte[30];
		int num = f_in.read(buffer);
		while(num != -1) {
			f_out.write(buffer,0,num);
			num = f_in.read(buffer);
		}
		f_in.close();
		f_out.close();
	}
}
