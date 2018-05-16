package Pruebas;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CrearObjetoDiscoXML {
	public static void main(String[] args) throws IOException, FileNotFoundException, ParserConfigurationException, SAXException{
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/xml/Discos/discop.xml");
		
		Element raiz = (Element) doc.getChildNodes().item(0);
		NodeList discos = raiz.getElementsByTagName("disco");
		Disco d;
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		Cancion c;
		
		ObjectOutputStream f_out = new ObjectOutputStream(new FileOutputStream("./archivos/xml/Discos/Discos.obj"));
		
		for(int i = 0; i< discos.getLength(); i++) {
			canciones.clear();
			Element el = (Element) discos.item(i);
			NodeList nodecan = el.getElementsByTagName("cancion");
		
			d = new Disco(i+1,Long.parseLong(el.getElementsByTagName("codigo_EAN").item(0).getFirstChild().getNodeValue()), 
					el.getElementsByTagName("autor").item(0).getFirstChild().getNodeValue(),
					el.getElementsByTagName("titulo").item(0).getFirstChild().getNodeValue(),
					el.getElementsByTagName("genero").item(0).getFirstChild().getNodeValue(),
					el.getElementsByTagName("estreno").item(0).getFirstChild().getNodeValue(),
					el.getElementsByTagName("sello_disco").item(0).getFirstChild().getNodeValue(),
					canciones,
					el.getElementsByTagName("informacion").item(0).getFirstChild().getNodeValue());
			
			for (int j = 0; j<nodecan.getLength(); j++) {
				Element cn = (Element) nodecan.item(j);
				c = new Cancion(d,cn.getFirstChild().getNodeValue());
				canciones.add(c);
			}
			f_out.writeObject(d);
			d.display();
		}
		f_out.close();
	}
}
