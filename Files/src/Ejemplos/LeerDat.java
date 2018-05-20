package Ejemplos;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerDat {
	public static void main(String[] args) throws IOException {
		
		DataInputStream f_in = new DataInputStream(new FileInputStream("./archivos/Empleados_copy2.dat"));
		
		while(f_in.available()>0) {
			System.out.print("Numero: " + f_in.readInt() + " Nombre: " + f_in.readUTF() + " Departamento: " + f_in.readInt() + "Edad: " + f_in.readInt() + " Sueldo: " + f_in.readDouble() + "\n");
		}
		f_in.close();
	}
}
