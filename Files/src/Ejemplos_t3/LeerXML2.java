package Ejemplos_t3;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXML2 {

    public static void main(String[] args)
            throws ParserConfigurationException, 
                    FileNotFoundException, 
                    IOException, 
                    SAXException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/coches.xml");
        Element root = doc.getDocumentElement(); // apuntar� al elemento ra�z
        NodeList hijos = root.getChildNodes();
        System.out.println(hijos.item(0).getNodeName()); // el primer hijo es el retorno de carro.
        System.out.println(hijos.item(1).getNodeName()); // el segundo hijo s� que �s vehiculo
        System.out.println(hijos.item(2).getNodeName()); // el tercer hijo es el retorno de carro.
        System.out.println(hijos.item(3).getNodeName()); // el cuarto hijo s� que �s vehiculo
        System.out.println(hijos.item(4).getNodeName()); // el quinto hijo es el retorno de carro.
        System.out.println(hijos.item(5).getNodeName()); // no existe el sexto hijo. Dar� error
    }
}
