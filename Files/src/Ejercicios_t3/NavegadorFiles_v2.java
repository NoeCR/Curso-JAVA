package Ejercicios_t3;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class NavegadorFiles_v2 {
	public static void main(String[] args) throws IOException {
		
		File f = File.listRoots()[0];
		ArrayList<File> dirs = new ArrayList<File>();
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
		int opcion;
		/*
		 * Boque para imprimir y guardar el listado de ficheros del directorio raiz del dispositivo
		 */
		do {
		int cont = 1;
		if(f.exists()) {
			if(f.isDirectory()) {
				System.out.println("Lista de ficheros y directorios del directorio: " + f.getCanonicalPath());
                System.out.println("---------------------------------------------------");
				
				for(File file: f.listFiles()) {
					if(!file.isHidden()) {
						System.out.println(cont + ".- \t" + permisos(file) + "\t" +  String.format("%-15d", file.length()) + formatter.format(file.lastModified()) + "\t" + file.getName());
						dirs.add(file);
						cont++;
					}
				}
				
			}else {
				System.out.println("No es un Directorio!");
			}
		}else {
			System.out.println("El Directorio no existe!");
		}
		/*
		 * Bloque para recibir una entrada de teclado del usuario, comprobar que es un numero y acceder al fichero almacenado en el indice 
		 */
			
			boolean ok;
			do { // Este bucle comprueba que la opcion es correcta
				ok = true;
				opcion = -1;
				do {// este bucle recoge y comprueba la entrada del teclado y la convierte a tipo Integer
					try {
						ok = true;
						System.out.println("Introduce una opción (-1 para salir): ");
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						opcion = Integer.parseInt(in.readLine());
					}catch(NumberFormatException nfe) {
						ok = false;
						System.out.println("Opcion incorrecta. Solo numeros enteros");
					}
				}while(!ok);	
					if(opcion == 0) {
						if(f.getParentFile() == null) { // Comprueba si el directorio padre es null, ya que estaríamos en la raiz
							System.out.println("Ya esta en el directorio raiz.");
							ok = false;
						}else {
							f = f.getParentFile();							
						}
					}else if(opcion != -1) {
						if(opcion > dirs.size()) { // Comprueba que la opcion este dentro del rango de valores del Array
							ok = false;
							System.out.println("Opcion incorrecta valores validos entre 0 y " + dirs.size());
						}else {
							if(!dirs.get(opcion-1).canRead()) {	// Comprueba que tenga permisos para acceder al Directorio	 						
								System.out.println("No tiene permisos para Leer este directorio" + dirs.get(opcion-1));
								ok = false;
							}else {
								f= dirs.get(opcion-1);								
							}
						}	
					}
			}while(!ok);	
		}while(opcion != -1);
			System.out.println("Fin del programa.");
	}
	public static String permisos(File f) {
		String permisos = "";
		if(f.isDirectory()) permisos += "d";
			else permisos += "-";
		if(f.canRead()) permisos += "r";
			else permisos += "-";
		if(f.canWrite()) permisos += "w";
			else permisos += "-";
		if(f.canExecute()) permisos += "x";
			else permisos += "-";
		return permisos;
	}
}
