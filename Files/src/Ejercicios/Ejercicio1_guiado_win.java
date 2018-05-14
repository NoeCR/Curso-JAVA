package Ejercicios;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Ejercicio1_guiado_win {

	public static void main(String[] args) throws IOException{
		File f = File.listRoots()[0];
		int opcion;
		ArrayList<File> directorios = new ArrayList<File>();
		do {
			boolean ok;
			directorios.clear();
			directorios = showAndGetFiles(f,directorios);
			do {
			    opcion = -1;
			    ok = true;
			    System.out.println("Introduce el numero o el nombre del directorio: ");
			    String in = new BufferedReader(new InputStreamReader(System.in)).readLine();
			   try {
				   ok = true;
				   opcion = Integer.parseInt(in);
				   if(0 == opcion) {
					   if(f.getParentFile() == null) {
						   System.out.println("Ya estamos en el directorio raiz");
						   ok = false;
					   }else {
						   f = f.getParentFile();
					   }
				   }else if(opcion != -1) {
					   if(opcion > directorios.size()) {
						   ok = false;
						   System.out.println("Opcion incorrecta. Valores v�lidos entre el 0 y " + directorios.size());
					   }else {
						   if(!directorios.get(opcion-1).canRead()) {
							   System.out.println("No tiene permisos para acceder al directorio: " + directorios.get(opcion-1));
							   ok = false;
						   }else {							  
							   f = directorios.get(opcion-1);
						   }
					   }						
				   }				   
			   }catch(NumberFormatException nfe) {
				   f = fileString(in,f);
				   if(f != null) {
					   System.out.println("Copntinua el programa");
				   }else {
					   System.out.println("Error en los datos de entrada" + nfe.getMessage());
				   }			   
				   
			   }
			}while(!ok);
			
		}while(opcion != -1);
			System.out.println("Fin del programa");
	}
	
	
	public static ArrayList<File> showAndGetFiles(File f, ArrayList<File> d) throws IOException{	
		DateFormat formato;
		formato = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
		if(f.exists()) {
			if(f.isDirectory()) {
				System.out.println("Lista de ficheros y directorios del directorio: " + f.getCanonicalPath());
				System.out.println("---------------------------------------------------");
				int count = 0;
				System.out.println(count +".- " + "Directorio padre ");
				for(File e : f.listFiles()) {					
					if(!e.isHidden()) {
						String permisos = getOptions(e);
						count++;
						if(e.isFile() || e.isDirectory()) {
							System.out.println(count + ".- \t" + permisos + "\t" +  String.format("%-15d", e.length()) + formato.format(e.lastModified()) + "\t" + e.getName());						
						}						
						d.add(e);
					}
				}				
			}else {
				System.out.println("No es un directorio");				
		  }
	   }else {
			System.out.println("Directorio no existe.");
		}
		return d;
	}
	public static String  getOptions(File f) {
		String permisos = "";
			if(f.isDirectory()) permisos += "d";
			else permisos +="-";
			if(f.canRead()) permisos += "r";
			else permisos +="-";
			if(f.canWrite()) permisos += "w";
			else permisos +="-";
			if(f.canExecute()) permisos += "x";
			else permisos +="-";
		return permisos;
	}
	public static File fileString(String s, File f) {
		boolean direxist = false;
		for (File e : f.listFiles()){
            if (!e.isHidden()) {
                if (e.isDirectory()) {
                	//System.out.println(e.getName().toLowerCase() + s.toLowerCase());
                	
                	if(e.getName().toLowerCase().trim().equals(s.toLowerCase().trim())) {
                		direxist = true;
                		System.out.println("Encontrado");
                		return e;
                	}                		
                }
            }
		}
		if(!direxist) {
			System.out.println("Ninguna cadena coincide con el nombre. " + s);
			return null;
		}
		return null;
	}
}
