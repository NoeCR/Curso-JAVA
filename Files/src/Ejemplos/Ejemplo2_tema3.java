package Ejemplos;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejemplo2_tema3 {

	public static void main(String[] args) throws IOException{
		DataInputStream f = new DataInputStream(new FileInputStream("./archivos/Empleados.dat"));
		
		while (f.available()>0) {
			System.out.println("Numero: " + f.readInt());
			System.out.println("Nombre: " +f.readUTF());
			System.out.println("Departamento: " + f.readInt());
			System.out.println("Edad: "  + f.readInt());
			System.out.println("Sueldo: " + f.readDouble());
			System.out.println();
		}
		f.close();
	}

}
