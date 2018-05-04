package Ejemplos;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		int select = 0;
		ArrayList<File> directorios = new ArrayList<File>();
		File f = File.listRoots()[0];
		
		

		do {
			int count = 0; 
			select = 0;
			if(f.exists()) {
				if(f.isDirectory()) {
					directorios.clear();
					System.out.println("Listado del directorio: " + f.getCanonicalPath());
					System.out.println(count + ".- Directorio padre");
					for (File e : f.listFiles()){
						count++;
						String s = comprobarPermisos(e);
						if(!f.isHidden()) {
							if(e.isDirectory()) {
								System.out.println(count + ". - " + s + "/t" + e + "<Directorio>");
								directorios.add(e);
							}else {
								System.out.println(count + ". - " + s + "/t" + e +" tamaño: " +e.length() +" Bytes");
								directorios.add(e);
							}
						}
			        }					
				}else {
					 System.out.println("No es un directorio");				
				}
			}else {
				System.out.println("No existe el directorio");
			}
			
			boolean ok;
			
			do {
				ok = true;
				do {				
					try {
						ok = true;
						System.out.println("Introduce una opcion (-1 para salir)");
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					    select = Integer.parseInt(in.readLine());
					}catch(java.lang.NumberFormatException nfe) {
						System.out.println("Opcion incorrecta");
						ok = false;
					}			        
			    }while(!ok);
				    if(select == 0) {
				    	if(f.getParentFile() == null) {
				    		System.out.println("Ya estamos en el directorio padre");
				    		ok = false;
				    	}else {
				    		f = f.getParentFile();
				    	}
				    }else if(select != -1) {
				    	if(select > directorios.size()) {
				    		ok = false;
				    		System.out.println("Opcion ioncorrecta.");
				    	}else {
				    		if(!directorios.get(select-1).canRead()) {
				    			System.out.println("No tiene permisos para acceder al directorio: " + directorios.get(select-1));
				    			ok = false;
				    		}else {
				    			f = directorios.get(select -1);
				    		}
				    	}
				    }
			}while(!ok);    
			    
		}while(select != -1);{
			System.out.println("Ha salido del programa");
			
		}
		
	}
	public static String comprobarPermisos(File f) {
		String permisos = "";
			if(f.isDirectory()) permisos +="d";
			else permisos +="-";
			if(f.canRead()) permisos +="r";
			else permisos +="-";
			if(f.canWrite()) permisos +="w";
			else permisos +="-";
			if(f.canExecute()) permisos +="x";
			else permisos +="-";
	return permisos;	
	}
}
