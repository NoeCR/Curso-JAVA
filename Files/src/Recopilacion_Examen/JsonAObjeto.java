package Recopilacion_Examen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;
public class JsonAObjeto {
	public static void main(String[] args) throws IOException {
		
		FileInputStream f_in = new FileInputStream("./archivos/repaso/Empleados.json");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f_in));
		
		ObjectOutputStream f_out = new ObjectOutputStream(new FileOutputStream("./archivos/repaso/Empleados_j_o.obj"));
		
		final Gson gson = new Gson();
		final Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> empleados = gson.fromJson(bufferedReader, tipoLista);
		
		for(Empleado e : empleados) {
			f_out.writeObject(e);
		}
		f_in.close();
		bufferedReader.close();
		f_out.close();
	}
}
