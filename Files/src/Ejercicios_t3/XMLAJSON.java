package Ejercicios_t3;

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
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class XMLAJSON {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {		

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/clientes.xml");
		Writer f_out = new FileWriter("./archivos/Clientes.json");
		String jsonClientes = "";
		
		Element raiz = (Element) doc.getChildNodes().item(0);
		NodeList clientes = raiz.getElementsByTagName("cliente");
		
		for(int i = 0; i < clientes.getLength(); i++) {
			Element el = (Element) clientes.item(i);
			
			jsonClientes += "{"
							+ "\"nombre\":\"" + el.getElementsByTagName("nombre").item(0).getFirstChild().getNodeValue() + "\","
							+ "\"telf\":" + Long.parseLong(el.getElementsByTagName("telf").item(0).getFirstChild().getNodeValue()) + ","
							+ "\"dir\":\"" + el.getElementsByTagName("dir").item(0).getFirstChild().getNodeValue() + "\","
							+ "},";
		}
		jsonClientes = jsonClientes.substring(0, jsonClientes.length()-1);
		jsonClientes = "[" + jsonClientes + "]";
		System.out.println(jsonClientes);
		final Gson gson = new Gson();
		final Type tipoListaClientes = new TypeToken<List<Cliente>>(){}.getType();
		
		final List<Cliente> c = gson.fromJson(jsonClientes, tipoListaClientes);
		final String representacionJSON = gson.toJson(c);
		f_out.write(representacionJSON);
		f_out.close();
	}
}
