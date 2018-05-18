package Pruebas;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DeXMLAJSON {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/xml/Discos/discop.xml");
		final Writer f_out = new FileWriter("./archivos/Discos.json");
		String jsonDiscos = "";
		
		Element raiz = (Element) doc.getChildNodes().item(0);
		NodeList discos = raiz.getElementsByTagName("disco");		
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		
		
		for(int i = 0; i< discos.getLength(); i++) {
			canciones.clear();
			Element el = (Element) discos.item(i);
			NodeList nodecan = el.getElementsByTagName("cancion");
			
			jsonDiscos += "{"
					  + "\"num\":\""  + 99 + "\","
					  + "\"ean\":\""  + Long.parseLong(el.getElementsByTagName("codigo_EAN").item(0).getFirstChild().getNodeValue()) + "\","
					  + "\"autor\":\""  + el.getElementsByTagName("autor").item(0).getFirstChild().getNodeValue() + "\","
					  + "\"titulo\":\""  + el.getElementsByTagName("titulo").item(0).getFirstChild().getNodeValue() + "\","
					  + "\"genero\":\""  + el.getElementsByTagName("genero").item(0).getFirstChild().getNodeValue() + "\","
					  + "\"estreno\":\""  + el.getElementsByTagName("estreno").item(0).getFirstChild().getNodeValue() + "\","
					  + "\"sello\":\""  + el.getElementsByTagName("sello_disco").item(0).getFirstChild().getNodeValue() + "\"," + "{" + "\"canciones\":\"[";
			for (int j = 0; j<nodecan.getLength(); j++) {
				Element cn = (Element) nodecan.item(j);				
				jsonDiscos += "\"cancion\":\""  + cn.getFirstChild().getNodeValue() + "\",";
			}	
			jsonDiscos +="]},"
					+ "\"info\":\""  + el.getElementsByTagName("informacion").item(0).getFirstChild().getNodeValue() + "\""
					+ "},";	
		}
		//Quitar la última coma
		jsonDiscos = jsonDiscos.substring(0, jsonDiscos.length()-1);
		//Crear el array de posts
		jsonDiscos = "[" + jsonDiscos + "]";
		System.out.println(jsonDiscos);
		final Gson gson = new Gson();
		final Type tipoListaPosts = new TypeToken<List<Disco>>(){}.getType();
		final List<Disco> disc = gson.fromJson(jsonDiscos, tipoListaPosts);
		final String representacionJSON = gson.toJson(disc);
		f_out.write(representacionJSON);
		f_out.close();
	}
}
