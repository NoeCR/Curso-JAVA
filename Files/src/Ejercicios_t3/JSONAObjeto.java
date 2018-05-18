package Ejercicios_t3;

import java.lang.reflect.Type;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONAObjeto {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		FileInputStream f_in = new FileInputStream("./archivos/Clientes.json");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f_in));
		
		ObjectOutputStream f_out = new ObjectOutputStream(new FileOutputStream("./archivos/Clientes_de_j_a_o.obj"));
		
		final Gson gson = new Gson();
		final Type tipoListaObjeto = new TypeToken<List<Cliente>>(){}.getType();
		final List<Cliente> clientes = gson.fromJson(bufferedReader, tipoListaObjeto);
		for(Cliente c: clientes) {
			f_out.writeObject(c);
		}
		f_out.close();
		bufferedReader.close();
		f_in.close();
	}
}
