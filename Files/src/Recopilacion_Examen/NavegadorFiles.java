package Recopilacion_Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class NavegadorFiles {

	public static void main(String[] args) throws IOException {
		
		File f = File.listRoots()[0];
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
		ArrayList<File> dirs = new ArrayList<File>();
		int opcion = -1;
		boolean ok;
		do {
		int cont = 1;
		if(f.exists()) {
			if(f.isDirectory()) {
				System.out.println("Archivos del directorio: " + f.getCanonicalPath());
				System.out.println("-------------------------------------------------");
				
				for(File file : f.listFiles()) {
					if(!file.isHidden()) {
						System.out.println(cont + ".- \t" + permisos(file) + "\t" +  String.format("%-15d", file.length()) + formatter.format(file.lastModified()) + "\t" + file.getName());
						dirs.add(file);
						cont++;						
					}
				}
				
			}else {
				System.out.println(f.getCanonicalPath() + "no es un Directorio");
			}
		}else {
			System.out.println("El Directorio no existe!");
		}
		do {
			try {
				ok = true;
				System.out.println("Seleccione el directorio. (-1 para salir)");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				opcion = Integer.parseInt(in.readLine());
				if(opcion == 0) {
					if(f.getParentFile() == null) {
						System.out.println("Ya esta en el directorio raíz.");
						ok = false;
					}else {
						f = f.getParentFile();
					}
				}else {
					if(opcion > f.length()) {
						System.out.println("El numero de directorio seleccionado no es valido rango de 0 -" + f.length());
						ok = false;
					}else if(opcion != -1){
						f = dirs.get(opcion - 1);
					}
				}
			}catch(NumberFormatException nfe) {
				ok = false;
				System.out.println("El dato de entrada no es un numero entero. ");
			}
		}while(!ok);
		}while(opcion != -1);
			System.out.println("Fin del programa!");
		
		
		
	}	
	public static String permisos(File f) {
		String p = "";
		if(f.isDirectory()) p += "d";
		else p += "-";
		if(f.canRead()) p += "r";
		else p += "-";
		if(f.canWrite()) p += "w";
		else p += "-";
		if(f.canExecute()) p += "x";
		else p += "-";
		return p;
	}
}
