package Pruebas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;


public class CrearJSONDeObjeto {
	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
		
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream("./archivos/Disco.obj"));
		Disco d = (Disco) f_in.readObject();
		//d.display();
		String disco = "{\"Disco\":" + d.getNum()+",\"codigo_EAN\":" + d.getEAN() +",\"autor\":" + d.getAutor()+ ",\"titulo\":" + d.getTitulo() +",\"genero\":" + d.getGenero() + ",\"estreno\":" + d.getEstreno();
		
			for(Cancion c : d.getCanciones()) {
				disco += ",\"cancion\":" + c.getNombre();
			}
		disco += ",\"info\":" + d.getInfo() + "}";
		
		
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		final String representacionJSON = gson.toJson(d); // toJson(disco);
		//System.out.println(representacionJSON);
		
		final Writer w_json = new FileWriter("./archivos/disco.json");
		w_json.write(representacionJSON);
		
		w_json.close();
		f_in.close();
	}
}
