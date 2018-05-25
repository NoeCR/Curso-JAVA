package Pruebas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjetos {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ObjectOutputStream f_out = new ObjectOutputStream(new FileOutputStream("./archivos/Empleados.obj"));
		
		String[] nombres = {"Pepe", "Jose", "Claudia", "Alicia"};
		long[] telfefonos = {964232315, 854744141, 655231585, 964789822};
		double[] sueldos = {1200.00, 1500.00, 1300.00, 2000.00};
		
		Empleado e;
		for(int i = 0; i < nombres.length; i++) {
			e = new Empleado(nombres[i],telfefonos[i],sueldos[i]);			
			f_out.writeObject(e);
		}
		f_out.close();
	}
}
