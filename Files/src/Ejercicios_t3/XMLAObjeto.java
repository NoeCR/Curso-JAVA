package Ejercicios_t3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLAObjeto {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/clientes.xml");
		ObjectOutputStream f_out = new ObjectOutputStream(new FileOutputStream("./archivos/Clientes.obj",true));
		Element raiz = (Element) doc.getChildNodes().item(0);
		NodeList cliente = raiz.getElementsByTagName("cliente");
		
		Cliente c;
		for (int i = 0; i < cliente.getLength(); i++) {
			Element el = (Element) cliente.item(i);
			c = new Cliente(el.getElementsByTagName("nombre").item(0).getFirstChild().getNodeValue(),
					el.getElementsByTagName("telf").item(0).getFirstChild().getNodeValue(),
					el.getElementsByTagName("dir").item(0).getFirstChild().getNodeValue());

			c.display();
			f_out.writeObject(c);
			
		}
		f_out.close();
	}

}
