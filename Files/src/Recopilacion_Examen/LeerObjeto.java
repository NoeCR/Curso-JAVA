package Recopilacion_Examen;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerObjeto {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream("./archivos/repaso/Empleados_agregados.obj"));
		
		Empleado e;
		try {
			while(true) {
				e = (Empleado) f_in.readObject();
				e.display();
			}
		}catch(EOFException eof) {
			f_in.close();
		}
	}
}
