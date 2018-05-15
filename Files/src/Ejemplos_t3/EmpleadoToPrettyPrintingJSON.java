package Ejemplos_t3;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EmpleadoToPrettyPrintingJSON {

	public static void main(String[] args) {
		
		final Empleado empleado = new Empleado(46,"Miguel",10,1100,00L);
		final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String prettyPrinting = prettyGson.toJson(empleado);
		System.out.println(prettyPrinting);
	}	
}
