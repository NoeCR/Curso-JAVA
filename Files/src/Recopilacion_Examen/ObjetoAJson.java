package Recopilacion_Examen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;

public class ObjetoAJson {

	public static void main(String[] args) throws IOException {
		
		Empleado e = new Empleado("Marcos", 964052132L, 900.50);
		
		final Gson gson = new Gson();
		final String JSON = gson.toJson(e);
		final Writer j_out = new FileWriter("./archivos/repaso/Empleado_o_j.json");
		
		j_out.write(JSON);
		j_out.close();
	}
}
