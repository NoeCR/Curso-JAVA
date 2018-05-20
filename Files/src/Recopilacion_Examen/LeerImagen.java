package Recopilacion_Examen;
import java.io.File;
import java.io.IOException;

public class LeerImagen {
public static void main(String[] args) throws IOException {
        
        File f = new File("./archivos/penyagolosa.bmp");
        
        TransformaImagen ti = new TransformaImagen(f);

        ti.transformaNegativo();
        ti.transformaOscuro();
        ti.transformaBlancoNegro();
        System.out.println(ti.getNombreSinExtension());
    }

}
