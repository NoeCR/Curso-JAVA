package Recopilacion_Examen;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Writer;

import java.util.List;

import java.lang.reflect.Type;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class ObjetosAJson {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream("./archivos/repaso/Empleados.obj"));

		String jsonEmpleados = "";
		
		Empleado e;
		
		try {
			while(true) {
				e = (Empleado) f_in.readObject();
				
				jsonEmpleados += "{" + "\"nombre\":\""  + e.getNombre() + "\","
									+ "\"telf\":\""  + String.valueOf(e.getTelf()) + "\","
									+ "\"sueldo\":\"" + String.valueOf(e.getSueldo()) + "\""
									+ "},";
			}
		}catch(EOFException eof) {
			f_in.close();
		}
		
		jsonEmpleados = jsonEmpleados.substring(0, jsonEmpleados.length()-1);
		jsonEmpleados = "[" + jsonEmpleados + "]";
		System.out.println(jsonEmpleados);
		final Gson gson = new Gson();
		final Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> posts = gson.fromJson(jsonEmpleados, tipoLista);
		final Writer w_json = new FileWriter("./archivos/repaso/Empleados_o_j.json");
		
		final String representacionJSON = gson.toJson(posts);
		
		w_json.write(representacionJSON);
		
		w_json.close();
	}
}
