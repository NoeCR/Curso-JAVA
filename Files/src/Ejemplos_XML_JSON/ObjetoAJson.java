package Ejemplos_XML_JSON;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileWriter;
import java.io.Writer;

import java.util.List;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class ObjetoAJson {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException{

		// Leer el archivo (previamente guardado como objeto)
		ObjectInputStream f = new ObjectInputStream(new FileInputStream("./archivos/Post.obj"));

		Post p;
		String jsonPosts = "";
		try {
			while (true) {
				// mientras haya posts
				p = (Post) f.readObject();
				
				//Convertirlo en una cadena json válida
				jsonPosts += "{"
							+ "\"from\":\""  + p.getFrom() + "\","
							+ "\"to\":\""  + p.getTo() + "\","
							+ "\"texto\":\""  + p.getTexto() + "\","
							+ "\"asunto\":\""  + p.getAsunto() + "\""
							+ "},";
			}

		} catch (EOFException eof) {
			f.close();
		}
		//Quitar la última coma
		jsonPosts = jsonPosts.substring(0, jsonPosts.length()-1);
		
		//Crear el array de posts
		jsonPosts = "[" + jsonPosts + "]";
		System.out.println(jsonPosts);
		final Gson gson = new Gson();
		final Type tipoListaPosts = new TypeToken<List<Post>>(){}.getType();
		final List<Post> posts = gson.fromJson(jsonPosts, tipoListaPosts);
		final Writer w_json = new FileWriter("./archivos/Posts.json");
		
		final String representacionJSON = gson.toJson(posts);
		
		w_json.write(representacionJSON);
		
		w_json.close();
	
	}
}