package Ejemplos_XML_JSON;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


import java.io.FileOutputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ObjetoAXml {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException {

		// Leer el archivo (previamente guardado como objeto)
		ObjectInputStream f = new ObjectInputStream(new FileInputStream("./archivos/Post.obj"));

		// Crear el documento (en memoria) para representar el XML
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		// Creamos la raíz
		Element root = doc.createElement("posts");
		/*
		 * Importante. Siempre que se crea un elemento hay que añadirlo!! a otro. En
		 * este caso a la raíz
		 */
		doc.appendChild(root);

		Post p;
		try {
			while (true) {
				// mientras haya posts
				p = (Post) f.readObject();
				Element post  = doc.createElement("post");
				
				// y creamos un nuevo elmento 
				Element el = doc.createElement("from");
				
				//Con el contenido
				el.appendChild(doc.createTextNode(p.getFrom()));
				
				//y lo añadimos al post
				post.appendChild(el);
				
				/*
				 * Hacemos lo mismo para cada uno de los datos
				 * NOTA. Si algún campo del objeto no es de tipo texto, hay que convertirlo
				 * Si fuera un int, por ejemplo, Integer.toString(e.getDepartamento())
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
				
				//Y añadir el post a la raíz
				root.appendChild(post);
			}

		} catch (EOFException eof) {
			f.close();
		}
		
		//Y ahora hay que guardarlo en un fichero
		Transformer trans = TransformerFactory.newInstance().newTransformer();

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("./archivos/Posts.xml"));

		trans.transform(source, result);
	}
}