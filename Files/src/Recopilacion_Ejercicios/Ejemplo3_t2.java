package Recopilacion_Ejercicios;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;


public class Ejemplo3_t2 {
	public static void main(String[] args) throws IOException {
		
		FileInputStream f1 = new FileInputStream("./archivos/f2.txt");
		String ent_1 = "Esto es un array de bytes con caracteres raros: � � �";
		ByteArrayInputStream f2 = new ByteArrayInputStream(ent_1.getBytes());
		SequenceInputStream f_in = new SequenceInputStream(f1, f2);
		
		int c = f_in.read();
		while (c != -1) {
			System.out.print((char) c);
			 c = f_in.read();
		}
		f_in.close();
		f1.close();
		f2.close();
	}
}
