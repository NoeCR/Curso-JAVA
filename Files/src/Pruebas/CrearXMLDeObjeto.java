package Pruebas;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class CrearXMLDeObjeto {
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException{
		
		
		ObjectInputStream f_disc = new ObjectInputStream(new FileInputStream("./archivos/xml/Discos/Discos.obj"));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element root = doc.createElement("discografica");
		doc.appendChild(root);
		
		Disco d;
		try {
			while(true) {
				d = (Disco) f_disc.readObject();
				Element disco = doc.createElement("disco");
				
				Element ean = doc.createElement("codigo_EAN");
				ean.appendChild(doc.createTextNode(Long.toString(d.getEAN())));
				disco.appendChild(ean);
				
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(d.getAutor()));
				disco.appendChild(autor);
				
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(d.getTitulo()));
				disco.appendChild(titulo);
				
				Element genero = doc.createElement("genero");
				genero.appendChild(doc.createTextNode(d.getGenero()));
				disco.appendChild(genero);
				
				Element estreno = doc.createElement("estreno");
				estreno.appendChild(doc.createTextNode(d.getEstreno()));
				disco.appendChild(estreno);
				
				Element sello = doc.createElement("sello_disco");
				sello.appendChild(doc.createTextNode(d.getSello()));
				disco.appendChild(sello);
				
				Element canciones = doc.createElement("canciones");
				Element cancion = doc.createElement("cancion");
				
				for(Cancion c : d.getCanciones()) {
					canciones.appendChild(cancion);
					cancion.appendChild(doc.createTextNode(c.getNombre()));
				}
				disco.appendChild(canciones);
				
				Element info = doc.createElement("informacion");
				info.appendChild(doc.createTextNode(d.getInfo()));
				disco.appendChild(info);
				
				
				root.appendChild(disco);
			}
		}catch(EOFException eof) {
			f_disc.close();
		}
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("./archivos/Discografica.xml"));
		trans.transform(source, result);
	}
}
