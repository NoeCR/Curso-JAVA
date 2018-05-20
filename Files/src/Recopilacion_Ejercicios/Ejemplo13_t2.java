package Recopilacion_Ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejemplo13_t2 {
	public static void main(String[] args) throws IOException{
		
		InputStreamReader f_ent = new InputStreamReader(new FileInputStream("./archivos/f3.txt"), "UTF-8");
		OutputStreamWriter f_sal = new OutputStreamWriter(new FileOutputStream("./archivos/f3_ISO_v2.txt"), "ISO-8859-1");
		
		int car = f_ent.read();
		while(car != -1) {
			f_sal.write(car);
			car = f_ent.read();
		}
		f_ent.close();
		f_sal.close();
	}
}
