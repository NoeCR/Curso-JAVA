package Recopilacion_Examen;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirObjeto {

	public static void main(String[] args) throws IOException{
		
		ObjectOutputStream obj_out = new ObjectOutputStream(new FileOutputStream("./archivos/repaso/Empleado.obj"));
		Empleado e = new Empleado("Marcos", 964052132L, 900.50);
		
		obj_out.writeObject(e);
	}
}
