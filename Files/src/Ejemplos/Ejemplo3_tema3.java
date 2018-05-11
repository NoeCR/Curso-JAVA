package Ejemplos;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejemplo3_tema3 {

	public static void main(String[] args) throws IOException{
	
		RandomAccessFile f = new RandomAccessFile("./archivos/Empleados.dat", "r");
		f.seek(56);
		System.out.println("Número: " + f.readInt());
		System.out.println("Nombre: " + f.readUTF());
		System.out.println("DEpartaemnto: " + f.readInt());
		System.out.println("Edad: " + f.readInt());
		System.out.println("Sueldo: " + f.readDouble());
		f.close();
		
	}
}
