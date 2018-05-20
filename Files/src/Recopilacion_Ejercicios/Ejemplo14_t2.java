package Recopilacion_Ejercicios;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Ejemplo14_t2 {
	public static void main(String[] args) throws IOException{
	
		BufferedReader f_ent = new BufferedReader(new FileReader("./archivos/f3.txt"));
		PrintWriter f_sal = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./archivos/f3_ISO_v2.txt")));
		
		String cad = f_ent.readLine();
		while(cad != null) {
			f_sal.println(cad);
			cad = f_ent.readLine();
		}
		f_ent.close();
		f_sal.close();
	}
}
