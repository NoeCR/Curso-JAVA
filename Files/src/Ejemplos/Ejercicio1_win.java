package Ejemplos;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ejercicio1_win {

	public static void main(String[] args) throws IOException{
		File f = new File(".");
		boolean salir = false;
		 System.out.println("Lista de ficheros y directorios del directorio actual");
	        System.out.println("---------------------------------------------------");
	        for (String e : f.list()){
	            System.out.println(e);
	        }
	       do { 
	        System.out.println("Introduce un directorio. o / para ir al directorio padre ");
	        String ent = new BufferedReader(new InputStreamReader(System.in)).readLine();
	        if(ent != "salir") {
	        	if(ent == "/"){
	        		f.getParentFile();
	        	}else {
	        		f = new File(ent);
	        	}
		        System.out.println("Lista de ficheros y directorios del directorio: " + ent);
		        System.out.println("---------------------------------------------------");
		        
		        for (File e : f.listFiles()){
		        	if(!e.isHidden())
		        		if(e.isFile())
		        			System.out.println(e.getName() + " " + e.length());
		        		if(e.isDirectory())
		        			System.out.println(e.getName() + "< Directorio > ");
		            
		        }
	        }else {
	        	salir = true;
	        }
	       }while(!salir); {
	    	   System.out.println("Ha salido del programa.");
	       }
	       
	}	
}
