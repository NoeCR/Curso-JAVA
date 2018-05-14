package Ejemplos_t3;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejemplo5_tema3 {

	public static void main(String[] args) throws IOException{
		
		RandomAccessFile f = new RandomAccessFile("./archivos/Empleados2.dat", "r");
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Que registro? (-1 para salir): ");
		int num = sc.nextInt();
		while(num != -1) {
			
			f.seek(32*(num-1));
			System.out.println("Número: " + f.readInt());
			System.out.println("Nombre: " + f.readUTF());
			System.out.println("departamentos: " + f.readInt());
			System.out.println("Edad: " + f.readInt());
			System.out.println("Sueldo: " + f.readDouble());
			System.out.println();
			System.out.println("¿Que registro? (-1 para salir): ");
			num = sc.nextInt();
		}
		f.close();
		sc.close();
	}

}
