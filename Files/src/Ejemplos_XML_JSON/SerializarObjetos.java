package Ejemplos_XML_JSON;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class SerializarObjetos {

	public static void main(String[] args) throws IOException {
		ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("./archivos/Post.obj"));
		
		Post p = new Post("¿Cómo estás", "pepe", "juan", "Hola");
		
		f.writeObject(p);
		p = new Post("Estoy muy bien", "juan", "pepe", "Respuesta a Hola");
		
		f.writeObject(p);
		
		f.close();
	}

}
