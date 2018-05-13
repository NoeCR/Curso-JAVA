package Tema_3;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXMLCoches {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException{
	
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream("./archivos/coches.xml"));
		Element raiz = (Element) doc.getChildNodes().item(0);
		NodeList vehiculos = raiz.getElementsByTagName("vehiculo");
		
		for(int i = 0; i< vehiculos.getLength(); i++) {
			
			Element el = (Element) vehiculos.item(i);
			System.out.println(el.getNodeName() + " " + (i + 1));
			System.out.println("Marca: " + el.getElementsByTagName("marca").item(0).getChildNodes().item(0).getNodeValue());
			System.out.println("Matrícula: " + el.getElementsByTagName("matricula").item(0).getFirstChild().getNodeValue());
			System.out.println("Motor: " + el.getElementsByTagName("motor").item(0).getTextContent());
			System.out.println("Combustible: " + el.getElementsByTagName("motor").item(0).getAttributes().item(0).getNodeValue());
			Element m = (Element) el.getElementsByTagName("motor").item(0);
			System.out.println("Combustible: " + m.getAttribute("combustible"));
			System.out.println();
		}
		System.out.println(raiz.getTextContent());
	}
}
