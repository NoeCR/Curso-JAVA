package Ejemplos_t3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearObjetoEmpleado {
	public static void main(String[] args) throws IOException{
		
		ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("./archivos/Empleados.obj"));
		
		String[] nombres = {"Andreu", "Bernat", "Claudia", "Damián", "Juan"};
		int[] Departamentos = {10,20,10,10,10};
		int[] edades  = {32,28,26,40,30};
		double[] sueldos = {1000.0,1200.0,1400.0,1300.0,1200.00};
		
		Empleado e;
		
		for(int i=0 ; i<4;i++) {
			e = new Empleado ( i+1 , nombres[i], Departamentos[i], edades[i], sueldos[i]);
			f.writeObject(e);
		}
		f.close();
	}
}
