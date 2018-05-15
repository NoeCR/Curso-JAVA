package Pruebas;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class LeerLibrosXML {
	public static void main(String[] args) throws IOException, FileNotFoundException, ParserConfigurationException, SAXException{
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/xml/Discos/discop.xml");
		
		Element raiz = (Element) doc.getChildNodes().item(0);
		NodeList discos = raiz.getElementsByTagName("disco");
		//Element disco = (Element) doc.getChildNodes().item(8);
		//NodeList canciones = raiz.getElementsByTagName("cancion");
		
		for(int i = 0; i< discos.getLength(); i++) {
			
			Element el = (Element) discos.item(i);
			System.out.println(el.getNodeName() + " " + (i + 1));
			System.out.println("textcontent: " + el.getElementsByTagName("textcontent").item(0).getChildNodes().item(0).getNodeValue());
			System.out.println("codigo_EAN: " + " " + el.getElementsByTagName("codigo_EAN").item(0).getFirstChild().getNodeValue());
			System.out.println("Autor: " + el.getElementsByTagName("autor").item(0).getChildNodes().item(0).getNodeValue());
			System.out.println("Titulo: " + el.getElementsByTagName("titulo").item(0).getChildNodes().item(0).getNodeValue());
			System.out.println("Genero: " + el.getElementsByTagName("genero").item(0).getChildNodes().item(0).getNodeValue());
			System.out.println("Estreno: " + el.getElementsByTagName("estreno").item(0).getChildNodes().item(0).getNodeValue());
			System.out.println("Sello Discografico: " + el.getElementsByTagName("sello_disco").item(0).getChildNodes().item(0).getNodeValue());
			//NodeList canciones = ((Document) discos).getElementsByTagName("canciones");
			NodeList numcan = el.getElementsByTagName("cancion");
			for (int j = 0; j<numcan.getLength(); j++) {
				Element cn = (Element) numcan.item(j);
				//System.out.println(cn.getNodeName() + " " + (j + 1) );
				System.out.println("Cancion " + (j+1) + ": "+ cn.getTextContent());
				//System.out.println(cn.getTextContent());
			}
		}

	}
}
