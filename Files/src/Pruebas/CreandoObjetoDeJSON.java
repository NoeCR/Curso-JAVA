package Pruebas;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class CreandoObjetoDeJSON {
	public static void main(String[] args) throws IOException, FileNotFoundException{
		
		FileReader f_in = new FileReader("./archivos/disco_v2.json"); //He usado esta clase por que las etiquetas y su contenido pueden tener caracteres especiales 
		String json = "";
		
		int c = f_in.read();
		
		while(c != -1) {
			json += (char)c;
			c = f_in.read();
		}
		
		final Gson gson = new Gson();
		final Disco disco = gson.fromJson(json, Disco.class);
		disco.display();
		
		
		f_in.close();
	}
}
