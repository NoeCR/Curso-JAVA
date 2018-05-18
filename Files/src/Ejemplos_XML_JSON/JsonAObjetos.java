package Ejemplos_XML_JSON;

import java.io.BufferedReader;
import java.io.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;




public class JsonAObjetos {
	public static void main(String[] args) throws IOException {

		final InputStream f = new FileInputStream("./archivos/Posts.json");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f));
		
		final Gson gson = new Gson();
		final Type tipoListaPosts = new TypeToken<List<Post>>(){}.getType();
		final List<Post> posts = gson.fromJson(bufferedReader, tipoListaPosts);
		for (Post p: posts) {
			 System.out.println("From: " + p.getFrom());
             System.out.println("to: " + p.getTo());
             System.out.println("Asunto: " + p.getAsunto());
             System.out.println("Mensaje: " + p.getTexto());
             System.out.println();
		}

		bufferedReader.close();
		

	}
}
