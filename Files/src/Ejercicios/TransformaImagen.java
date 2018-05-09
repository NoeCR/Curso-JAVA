package Ejercicios;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FilenameFilter;

public class TransformaImagen {

    File f = null;

    public TransformaImagen(File fEnt) throws IOException{
        // Control de existencia del fichero y control de la extensión .bmp (sacar mensajes de error)
    	if(fEnt.canRead()) {
	    	if(fEnt.exists()) {
	    		if(fEnt.isFile()) {
	    			 if (fEnt.getName().endsWith(".bmp")) {	    				 
	    				f = fEnt;	    				 
	    			 }else {
	    				 System.out.println("El archivo no es del formato correcto");
	    			 }
	    		}else {
	    			System.out.println("El archivo no es del tipo correcto");
	    		}
	    	}else {
	    		System.out.println("El archivo no existe");
	    	}
    	}else {
    		System.out.println("No tiene permisos para leer el archivo");
    	}
    }
    public void transformaNegativo() throws IOException {

        // Transformar a negativo y guardar como *_n.bmp
    	 FileInputStream  f_in = new FileInputStream(f);	    				 
		 FileOutputStream f_out = new FileOutputStream("./archivos/penya_n.bmp");
		 
		 byte[] metadatos = new byte[54];
		 int nummeta = f_in.read(metadatos);
		 f_out.write(metadatos);
		 
		
		 int numrgb = f_in.read();
		 while(numrgb != -1) {
			 f_out.write(255 - numrgb);
			 numrgb = f_in.read();
			 
		 }  				 
		 
		 f_in.close();
		 f_out.close(); 

    }
    public void transformaOscuro() throws IOException {

        // Transformar a una imagen más oscura y guardar como *_o.bmp
    	FileInputStream  f_in = new FileInputStream(f);	    				 
		 FileOutputStream f_out = new FileOutputStream("./archivos/penya_o.bmp");
		 
		 byte[] metadatos = new byte[54];
		 int nummeta = f_in.read(metadatos);
		 f_out.write(metadatos);
		 
		
		 int numrgb = f_in.read();
		 while(numrgb != -1) {
			 f_out.write(numrgb/2);
			 numrgb = f_in.read();
			 
		 }
		 f_in.close();
		 f_out.close(); 

    }
    public void transformaBlancoNegro() throws IOException {

        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
    	 FileInputStream  f_in = new FileInputStream(f);	    				 
		 FileOutputStream f_out = new FileOutputStream("./archivos/penya_bn.bmp");
		 
		 byte[] metadatos = new byte[54];
		 int nummeta = f_in.read(metadatos);
		 f_out.write(metadatos);
/*			 
		 byte[] rgb = new byte[3];
		 int numrgb = f_in.read(rgb);
		 while(numrgb != -1) {
			 if(rgb[0] < 0) {
				 rgb[0] += 256;
			 }
			 if(rgb[1] < 0) {
				 rgb[1] += 256;
			 }
			 if(rgb[2] < 0) {
				 rgb[2] += 256;
			 }
			 int media = 
		 }
*/		 
		 int r = f_in.read();
		 int g = f_in.read();
		 int b = f_in.read();
		 
		 while(b != -1) {
			 //Proceso ....
			 if(r < 0) {
				 r = r + 256;
			 }
			 if(g < 0) {
				 g = g + 256;
			 }
			 if(b < 0) {
				 b = b + 256;
			 }
			 int media = (r+g+b) / 3;
			 // Escribo
			 f_out.write(media);
			 f_out.write(media);
			 f_out.write(media);
			 //Leo
			 r = f_in.read();
			 g = f_in.read();
			 b = f_in.read(); 
			 
		 }  				 

 
		 f_in.close();
		 f_out.close(); 

    }
    public String getNombreSinExtension() {

        //Devuelve el nombre del archivo f sin extensión
    	String nombre = f.getName().substring(0,f.getName().indexOf('.'));
        //System.out.println(nombre);
    	return nombre;
    }
}