package Ejemplos_t3;
import com.google.gson.Gson;;

public class JSONEnUnObjeto {
	public static void main(String[] args) {
		
		final String json = "{\"num\":46,\"nombre\":\"Miguel\",\"departamento\":10,\"edad\":20,\"sueldo\":1200.00}";
		final Gson gson = new Gson();
		final Empleado empleado = gson.fromJson(json, Empleado.class);
		empleado.display();
	}
}
