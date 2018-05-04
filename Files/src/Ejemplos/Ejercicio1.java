package Ejemplos;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		int count = 0; 
		int select;
		ArrayList<File> directorios = new ArrayList<File>();
		File f = File.listRoots()[0];
		
		

		do {
			System.out.println("Listado del directorio: " + f.getCanonicalPath());
			for (File e : f.listFiles()){
				count++;
				if(e.isDirectory()) {
					System.out.println(count + ". - " + e + "<Directorio>");
					directorios.add(e);
				}else {
					System.out.println(count + ". - " + e);
				}
	        }
			
			System.out.println("Seleccione el directorio: " + "\n" +
								"Directorio padre 0 " + "\n");
			Scanner inputValue = new Scanner(System.in);
		    select = inputValue.nextInt();
			
			switch (select) {
            case 0:  select = 0;  
            	System.out.println("Seleccionado 0");
                     break;
            case 1:  select = 1;
            	System.out.println("Seleccionado 1");
                     break;
        }
		}while(select != -1);{
			System.out.println("Ha salido del programa");
			
		}
	}	
}
