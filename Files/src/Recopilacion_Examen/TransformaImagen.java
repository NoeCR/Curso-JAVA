package Recopilacion_Examen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TransformaImagen {
    File f = null;

    public TransformaImagen(File fEnt) {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)
    	if(fEnt.exists()) {
    		if(fEnt.getName().endsWith(".bmp")){
    			System.out.println("archivo correcto!");
    			f = fEnt;
    		}else {
    			System.out.println("El archivo no es valido.");
    		}
    	}else {
    		System.out.println("El archivo no existe.");
    	}
    }

    public void transformaNegativo() throws IOException {
        // Transformar a negativo y guardar como *_n.bmp
    	FileInputStream f_in = new FileInputStream(f);
    	FileOutputStream f_out = new FileOutputStream (new File("./archivos/repaso/penya_n.bmp"));
    	
    	byte[] metadatos = new byte[54];
    	f_in.read(metadatos);
    	f_out.write(metadatos);
    	
    	int num = f_in.read();
    	while(num != -1) {
    		f_out.write(255 - num);
    		num = f_in.read();
    	}
    	f_in.close();
    	f_out.close();
    }

    public void transformaOscuro() throws IOException {
        // Transformar a una imagen más oscura y guardar como *_o.bmp
    	FileInputStream f_in = new FileInputStream(f);
    	FileOutputStream f_out = new FileOutputStream (new File("./archivos/repaso/penya_o.bmp"));
    	
    	byte[] metadatos = new byte[54];
    	f_in.read(metadatos);
    	f_out.write(metadatos);
    	
    	int num = f_in.read();
    	while(num != -1) {
    		f_out.write(num / 2);
    		num =  f_in.read();
    	}
        f_in.close();
        f_out.close();
    }
    
    public void transformaBlancoNegro() throws IOException {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
    	FileInputStream f_in = new FileInputStream(f);
    	FileOutputStream f_out = new FileOutputStream (new File("./archivos/repaso/penya_bn.bmp"));

    	byte[] metadatos = new byte[54];
    	f_in.read(metadatos);
    	f_out.write(metadatos);
    	
    	byte[] rgb = new byte[3];
    	
     	int r = f_in.read();
		int g = f_in.read();
		int b = f_in.read();
    	while(r != -1) {    		
    		if( r < 0) {
    			r = r + 256;
    		}
    		if(g < 0) {
    			g = g + 256;
    		}
    		if(b < 0) {    			
    			b = b + 256;
    		}
    		int media = (r + g + b)/3;
    		f_out.write(media);
    		f_out.write(media);
    		f_out.write(media);
    		r = f_in.read();
    		g = f_in.read();
    		b = f_in.read();
    	}
    	f_in.close();
    	f_out.close();
    }

    public String getNombreSinExtension() {
        //Devuelve el nombre del archivo f sin extensión
        return f.getName().substring(0, f.getName().indexOf("."));
    }
}
/*

*/