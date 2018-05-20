package Recopilacion_Examen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlAObjeto {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/repaso/Empleados.xml");
		ObjectOutputStream f_out = new ObjectOutputStream(new FileOutputStream("./archivos/repaso/Empleados_x_o.obj"));
		Empleado e;
		
		Element root = (Element) doc.getChildNodes().item(0);
		NodeList empleados = root.getElementsByTagName("cliente");
		
		for(int i = 0; i < empleados.getLength(); i++) {
			
			Element empleado = (Element) empleados.item(i);
			e = new Empleado(empleado.getElementsByTagName("nombre").item(0).getNodeValue(), 
					Long.parseLong(empleado.getElementsByTagName("telf").item(0).getNodeValue()), 
					Double.parseDouble(empleado.getElementsByTagName("sueldo").item(0).getNodeValue()));
			f_out.writeObject(e);
		}
		f_out.close();
	}
}
