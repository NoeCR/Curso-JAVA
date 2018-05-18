package Ejercicios_t3;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.BufferedReader;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
public class JsonAXml {

	public static void main(String[] args) throws IOException, FileNotFoundException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		FileInputStream f_in = new FileInputStream("./archivos/Clientes.json");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f_in));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element root = doc.createElement("clientes");
		doc.appendChild(root);
		
		final Gson gson = new Gson();
		final Type tipoLista = new TypeToken<List<Cliente>>(){}.getType();
		final List<Cliente> clientes = gson.fromJson(bufferedReader, tipoLista);
		
		for(Cliente c: clientes) {
			Element cliente = doc.createElement("cliente");
			
			Element nombre = doc.createElement("nombre");
			nombre.appendChild(doc.createTextNode(c.getNombre()));
			cliente.appendChild(nombre);
			
			Element telf = doc.createElement("telf");
			telf.appendChild(doc.createTextNode(c.getTelf()));
			cliente.appendChild(telf);
			
			Element dir = doc.createElement("dir");
			dir.appendChild(doc.createTextNode(c.getDir()));
			cliente.appendChild(dir);
			
			root.appendChild(cliente);
		}
		
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("./archivos/Clientes_de_j_a_x.xml"));
		
		trans.transform(source, result);
		
		bufferedReader.close();
		f_in.close();
	}

}
