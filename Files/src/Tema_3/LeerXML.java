package Tema_3;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class LeerXML {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException{
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/coches.xml");
		
		System.out.println(doc.getNodeName());
		
		Element root = doc.getDocumentElement();
		
		System.out.println(root.getNodeName());
		
		System.out.println(root.getNodeValue());
	}

}
