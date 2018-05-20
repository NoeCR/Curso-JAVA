package Recopilacion_Examen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class JsonAXml {
	public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		FileInputStream f_in = new FileInputStream("./archivos/repaso/Empleados.json");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f_in));

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element root = doc.createElement("empleados");
		doc.appendChild(root);
		
		final Gson gson = new Gson();
		final Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> empleados = gson.fromJson(bufferedReader, tipoLista);		
		
		for(Empleado e: empleados) {
			
			Element empleado = doc.createElement("empleado");
			
			Element nombre = doc.createElement("nombre");
			nombre.appendChild(doc.createTextNode(e.getNombre()));
			empleado.appendChild(nombre);
			
			Element telf = doc.createElement("telf");
			telf.appendChild(doc.createTextNode(String.valueOf(e.getTelf())));
			empleado.appendChild(telf);
			
			Element sueldo = doc.createElement("sueldo");
			sueldo.appendChild(doc.createTextNode(String.valueOf(e.getSueldo())));
			empleado.appendChild(sueldo);
			
			root.appendChild(empleado);			
		}
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("archivos/repaso/Empleados_j_x.xml"));
		trans.transform(source, result);
	}
}
