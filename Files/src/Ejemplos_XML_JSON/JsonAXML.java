package Ejemplos_XML_JSON;

import java.io.BufferedReader;
import java.io.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.reflect.Type;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileOutputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class JsonAXML {
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException {

		final InputStream f = new FileInputStream("./archivos/Posts.json");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f));

		// Crear el documento (en memoria) para representar el XML
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		// Creamos la raíz
		Element root = doc.createElement("posts");
		/*
		 * Importante. Siempre que se crea un elemento hay que añadirlo!! a otro. En
		 * este caso a la raíz
		 */
		doc.appendChild(root);

		final Gson gson = new Gson();
		final Type tipoListaPosts = new TypeToken<List<Post>>() {
		}.getType();
		final List<Post> posts = gson.fromJson(bufferedReader, tipoListaPosts);
		for (Post p : posts) {
			Element post = doc.createElement("post");

			// y creamos un nuevo elmento
			Element el = doc.createElement("from");

			// Con el contenido
			el.appendChild(doc.createTextNode(p.getFrom()));

			// y lo añadimos al post
			post.appendChild(el);

			/*
			 * Hacemos lo mismo para cada uno de los datos NOTA. Si algún campo del objeto
			 * no es de tipo texto, hay que convertirlo Si fuera un int, por ejemplo,
			 * Integer.toString(e.getDepartamento())
			 */

			el = doc.createElement("to");
			el.appendChild(doc.createTextNode(p.getTo()));
			post.appendChild(el);

			el = doc.createElement("Asunto");
			el.appendChild(doc.createTextNode(p.getAsunto()));
			post.appendChild(el);

			el = doc.createElement("Mensaje");
			el.appendChild(doc.createTextNode(p.getTexto()));
			post.appendChild(el);

			// Y añadir el post a la raíz
			root.appendChild(post);
		}
		// Y ahora hay que guardarlo en un fichero
		Transformer trans = TransformerFactory.newInstance().newTransformer();

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("./archivos/PostsDesdeJson.xml"));

		trans.transform(source, result);
		bufferedReader.close();

	}
}
