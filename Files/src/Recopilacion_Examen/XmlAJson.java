package Recopilacion_Examen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.util.List;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlAJson {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/repaso/Empleados.xml");
		
		final Writer f_out = new FileWriter("./archivos/repaso/Empleados_x_j.json");
		
		String jsonEmpleados = "";
		
		Element root = (Element) doc.getChildNodes().item(0);
		NodeList empleados = root.getElementsByTagName("empleado");
		
		for(int i = 0; i < empleados.getLength(); i++) {
			Element empleado = (Element) empleados.item(i);
			
			jsonEmpleados += "{" + "\"nombre\":\"" + empleado.getElementsByTagName("nombre").item(0).getFirstChild().getNodeValue() + "\"," 
								+ "\"telf\":" +  Long.parseLong(empleado.getElementsByTagName("telf").item(0).getFirstChild().getNodeValue()) + ","
								+ "\"sueldo\":" + Double.parseDouble(empleado.getElementsByTagName("sueldo").item(0).getFirstChild().getNodeValue()) + "},";
		}
		
		jsonEmpleados = jsonEmpleados.substring(0,jsonEmpleados.length()-1);
		jsonEmpleados = "[" + jsonEmpleados + "]";
		
		final Gson gson = new Gson();
		final Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> emp = gson.fromJson(jsonEmpleados, tipoLista);
		final String JSON = gson.toJson(emp);
		f_out.write(JSON);
		f_out.close();
	}
}
