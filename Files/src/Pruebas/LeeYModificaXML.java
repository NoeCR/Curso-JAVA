package Pruebas;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;

public class LeeYModificaXML {
public static void main(String[] args) throws IOException, FileNotFoundException, ParserConfigurationException, SAXException{
	
		FileReader f_in = new FileReader("./archivos/xml/Discos/discografica.xml");
		FileWriter f_out = new FileWriter("./archivos/xml/Discos/discografica_mod.xml");
		String doc = null;
		//char[] prologo = new char[1];
	    //xmldiscos.read(prologo);
		//f_in.read(prologo);
		int c = f_in.read();
		while(c !=-1) {
			System.out.print((char)c);
			doc += (char)c;			
			c = f_in.read();
		}
		f_in.close();
		doc = modificarCadena(doc);
		System.out.println(doc);

   try {
			
			for(int i = 0; i < doc.length(); i++) {
				f_out.write(doc.charAt(i));
			}
		}finally {
			if(f_out != null) f_out.close();
		}

   	printXML();
   	
	}
public static String modificarCadena(String doc) {	
	return doc.replaceAll("\n", "").replaceAll("\\t", "").replaceAll("\\s", "").trim();
}
public static void printXML() throws SAXException, IOException, ParserConfigurationException {
	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/xml/Discos/discografica_mod.xml");		
	Element raiz = (Element) doc.getChildNodes().item(0);
	NodeList discos = raiz.getElementsByTagName("disco");
			
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
		NodeList numcan = el.getElementsByTagName("cancion");
		for (int j = 0; j<numcan.getLength(); j++) {
			Element cn = (Element) numcan.item(j);				
			System.out.println("Cancion " + (j+1) + ": "+ cn.getTextContent());				
		}
	}
	}
}
