package Ejercicios_t3;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;


public class NavegadorFIles {
	public static void main(String[] args) throws IOException {
		
		File f = File.listRoots()[0];
		ArrayList<File> dirs = new ArrayList<File>();
		DateFormat formatter;
		formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
		int num, opcion;
		do {
			num = 1;
			opcion = -1;
			boolean ok;
			if(f.exists()) {
				if(f.isDirectory()) {
				dirs.clear();	
				System.out.println("Lista de ficheros y directorios del directorio: " + f.getCanonicalPath());
				System.out.println("---------------------------------------------------");
				for(File file: f.listFiles()) {					
					if(file.canRead()) {
						if(!file.isHidden()) {
							if(file.isDirectory()) {
								System.out.println(num + ".- \t" + permisos(file) + "\t" +  String.format("%-15d", file.length()) + formatter.format(file.lastModified()) + "\t" + file.getName());
								dirs.add(file);
							}else {
								System.out.println(num + ".- \t" + permisos(file) + "\t" +  String.format("%-15d", file.length()) + formatter.format(file.lastModified()) + "\t" + file.getName());
								dirs.add(file);
							}
						num++;
						}
					}				
				}
				do {
					try {
						ok = true;
						System.out.println("Introduzca el número del directorio o el nombre: ");
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						opcion = Integer.parseInt(in.readLine());
					}catch(NumberFormatException nfe) {
						System.out.println("no es un numero");
						ok = false;
					}
				}while(!ok);
				if(opcion == 0 ) {
					f.getParentFile();
					System.out.println("Directorio padre: " + f.getCanonicalPath());					
				}else if(opcion != -1){
					
					f = dirs.get(opcion-1);
				}
			}else {
				System.out.println("No es un directorio ");
			}
		}else {
			System.out.println("El Directorio no existe");
		}
		}while(opcion != -1);
		
		
	}
	
	public static String permisos(File f) {
		String per = "";
		if(f.isDirectory()) per +="d";
		else per +="-";
		if(f.canRead()) per +="r";
		else per +="-";
		if(f.canWrite()) per +="w";
		else per +="-";
		if(f.canExecute()) per +="x";
		else per +="-";
		
		return per;		
	}
}
