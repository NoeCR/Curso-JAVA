package Ejercicios_t3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ObjetoAJSON {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream("./archivos/Clientes.obj"));
		
		Cliente c;
		String jsonCliente ="";
		
		try {
			while(true) {
				c = (Cliente) f_in.readObject();
				jsonCliente += "{" + "\"nombre\":\"" + c.getNombre() + "\","
						 		   + "\"telf\":\"" 	+ c.getTelf() + "\","
						 		   + "\"dir\":\"" + c.getDir() + "\"" + "},";
				
			}
		}catch(EOFException eof) {
			f_in.close();
		}
		
		jsonCliente = jsonCliente.substring(0,jsonCliente.length()-1);
		jsonCliente = "[" + jsonCliente +"]";
		System.out.println(jsonCliente);
		
		final Gson gson = new Gson();
		final Type tipoCliente = new TypeToken<List<Cliente>>(){}.getType();
		final List<Cliente> clientes = gson.fromJson(jsonCliente, tipoCliente);
		final Writer w_json = new FileWriter("./archivos/Clientes.json");
		final String JSON = gson.toJson(clientes);
		w_json.write(JSON);
		w_json.close();
	}
}
