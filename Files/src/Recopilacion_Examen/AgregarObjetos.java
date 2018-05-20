package Recopilacion_Examen;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AgregarObjetos {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		ObjectInputStream objs_in = new ObjectInputStream(new FileInputStream("./archivos/repaso/Empleados.obj"));
		ObjectInputStream obj_in = new ObjectInputStream(new FileInputStream("./archivos/repaso/Empleado.obj"));
		ObjectOutputStream obj_out = new ObjectOutputStream(new FileOutputStream("./archivos/repaso/Empleados_agregados.obj", true));
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Empleado e = (Empleado) obj_in.readObject();
		Empleado i = new Empleado("Lidia" , 666235214 , 2300.00);
		
		try {
			while(true) {
				empleados.add((Empleado)objs_in.readObject());
			}
		}catch(EOFException eof) {
			objs_in.close();
		}
		if(e != null) {
			empleados.add(e);
			obj_in.close();
		}
		if(i != null) empleados.add(i);
		for(Empleado emp: empleados) {
			obj_out.writeObject(emp);
		}
		obj_out.close();
	}
}
