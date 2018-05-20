package Ejemplos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturaEscrituradata {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		
		DataInputStream f_in = new DataInputStream(new FileInputStream("./archivos/Empleados.dat"));
		DataOutputStream f_out = new DataOutputStream(new FileOutputStream("./archivos/Empleados_copy.dat"));
		
		while(f_in.available()>0) {
			//System.out.print("Numero: " + f_in.readInt() + " Nombre: " + f_in.readUTF() + " Departamento: " + f_in.readInt() + "Edad: " + f_in.readInt() + " Sueldo: " + f_in.readDouble() + "\n");	
			
			f_out.writeInt(f_in.readInt());
			f_out.writeUTF(f_in.readUTF());
			f_out.writeInt(f_in.readInt());
			f_out.writeInt(f_in.readInt());
			f_out.writeDouble(f_in.readDouble());	
				
		}
		f_in.close();
		f_out.close();
	}
}
