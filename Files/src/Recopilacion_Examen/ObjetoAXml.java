package Recopilacion_Examen;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ObjetoAXml {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, ClassNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream("./archivos/repaso/Empleados.obj"));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element root = doc.createElement("empleados");
		doc.appendChild(root);
		
		Empleado e;
		
		try {
			while(true) {
				e = (Empleado) f_in.readObject();
				
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
		}catch(EOFException eof) {
			f_in.close();
		}
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("archivos/repaso/Empleados_o_x.xml"));
		trans.transform(source, result);
	}
}
