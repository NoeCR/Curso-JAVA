package Ejemplos_t3;
import java.util.Properties;
import com.google.gson.Gson;


public class JSONEnUnPropieties {
	public static void main(String[] args) {
		
		final String json = "{\"num\":46,\"nombre\":\"Miguel\",\"departamento\":10,\"edad\":20,\"sueldo\":1200.00}";
		final Gson gson = new Gson();
		final Properties properties = gson.fromJson(json, Properties.class);
		System.out.println(properties.getProperty("num"));
		System.out.println(properties.getProperty("nombre"));
		System.out.println(properties.getProperty("departamento"));
		System.out.println(properties.getProperty("edad"));
		System.out.println(properties.getProperty("sueldo"));
		
	}
}
