package Ejercicios_t3;
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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ObjetoAXML {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, ClassNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream("./archivos/Clientes.obj"));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element root = doc.createElement("clientes");
		doc.appendChild(root);
		
		Cliente c;
		try {
			while(true) {
				c = (Cliente) f_in.readObject();
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
		}catch(EOFException eof) {
			f_in.close();
		}
		
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("./archivos/Clientes_de_o_a_x.xml"));
		trans.transform(source, result);
	}
}
