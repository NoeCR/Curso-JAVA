package Pruebas;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.*;

public class Contador {
	public static void main(String[] args) throws Exception {

		Instant before = Instant.now();
		System.out.println("Introduce algo:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String entrada = in.readLine();	
		Instant after = Instant.now();
		long delta = Duration.between(before, after).toMillis();
		delta = delta /1000;
		System.out.println("Se ha tardado: " + delta + " segundos, En introducir la cadena :" + entrada);
    }
}
