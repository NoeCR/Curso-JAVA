package Ejercicios;
import java.io.File;
import java.io.IOException;
public class Ejercicio1_guiado {

	public static void main(String[] args) throws IOException {
		//Empezamos por el directorio raíz de la unidad 0
        File f = File.listRoots()[0];        

        if (f.exists()){
            if (f.isDirectory()){
                System.out.println("Lista de ficheros y directorios del directorio: " + f.getCanonicalPath());
                System.out.println("---------------------------------------------------");

                int cont = 0;
                System.out.println(cont +".- " + "Directorio padre ");
                for (File e : f.listFiles()){
                    //No imprime los ficheros/directorios ocultos
                    if (!e.isHidden()) {
                        //Aumentamos el contador para imprimirlo junto con el nombre de archivo o directorio

                        cont++;

                        if (e.isFile())
                            System.out.println(cont + ".- " +  e.getName() + " " + e.length() + " bytes");
                        if (e.isDirectory())
                            System.out.println(cont + ".- " +  e.getName() + " <Directorio>");
                    }
                }
            }
            else{

                System.out.println("No es un directorio");
            }
        }
        else{

            System.out.println("No existe el directorio");
        }
        System.out.println("Fin del programa");

    }

}


