package Recopilacion_Ejercicios;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Ejemplo12_t2 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader f_ent = new BufferedReader(new FileReader("./archivos/f8_ent_v2.txt"));
		PrintWriter f_sal = new PrintWriter(new FileWriter("./archivos/f8_sal_v2.txt"));
		String cad = f_ent.readLine();
		int i = 0;
		while(cad != null) {
			i++;
			f_sal.println(i + " - " + cad);
			cad = f_ent.readLine();
		}
		f_ent.close();
		f_sal.close();
	}
}
