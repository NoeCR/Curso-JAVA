package Ejercicios;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;


public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		int select = 0;
		//String nombre;
		ArrayList<File> directorios = new ArrayList<File>();
		File f = File.listRoots()[0];
		DateFormat formatter;

		formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
		

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
								System.out.println(count + ". - " + s + "\t" +  String.format("%-15d", e.length()) + formatter.format(e.lastModified()) + "\t" + e.getName());
								directorios.add(e);
							}else {
								System.out.println(count + ". - " + s + "\t" +  String.format("%-15d", e.length()) + formatter.format(e.lastModified()) + "\t" + e.getName());
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
						System.out.println("Introduce una opcion (-1 para salir) o (-2 para introducir el nombre)");
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
				    }else if(select != -1 && select != -2) {
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
				    }else if(select == -2) {
				    	//metodo para comprobar strings y buscar el directorio
				    	
				    	try {
							ok = true;
							System.out.println("Introduce nombre de directorio: ");
							//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
							//nombre1 =  in.readLine();
							String nombre = new BufferedReader(new InputStreamReader(System.in)).readLine();
							File fs = fileString(nombre,f);
							if(!fs.canRead()) {
				    			System.out.println("No tiene permisos para acceder al directorio: " + directorios.get(select-1));
				    			ok = false;
				    		}else {
				    			f = fs;
				    		}
						}catch(java.lang.StringIndexOutOfBoundsException sbe) {
							System.out.println("Cadena de texto incorrecta");
							ok = false;
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
	public static File fileString(String s, File f) {
		boolean direxist = false;
		for (File e : f.listFiles()){
            if (!e.isHidden()) {
                if (e.isDirectory()) {
                	//System.out.println(e.getName().toLowerCase() + s.toLowerCase());
                	if((String)e.getName().toLowerCase().trim() == s.toLowerCase().trim()) {
                		direxist = true;
                		System.out.println("Encontrado");
                		return e;
                	}                		
                }
            }
		}
		if(!direxist) {
			System.out.println("Ninguna cadena coincide con el nombre. " + s);
			return f;
		}
		return f;
	}
	
}


