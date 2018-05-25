package Pruebas;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class TheSerializer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2578754006130290751L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private File f = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheSerializer frame = new TheSerializer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TheSerializer() throws FileNotFoundException, IOException, ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("The Serializer!");
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 564, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton select = new JButton("Select");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser selectorArchivos = new JFileChooser();
				selectorArchivos.setCurrentDirectory(new File("./archivos"));
				selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int resultado = selectorArchivos.showOpenDialog(panel);
				f = selectorArchivos.getSelectedFile();	
				if ((f == null) || (f.getName().equals(""))) {
					 JOptionPane.showMessageDialog(textArea, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
				}
				try {					
					textField.setText(f.getCanonicalPath());
					try {
						if(f.isFile() && f.canRead()) {
							if(f.getCanonicalPath().endsWith(".xml")) {								
								String xml = leerXml(f);
								textArea.setText(xml);
							}else if(f.getCanonicalPath().endsWith(".obj")) {
								String obj = leerObjetos(f);						
								textArea.setText(obj);
							}else if(f.getCanonicalPath().endsWith(".json")) {
								String json = leerJson(f);
								textArea.setText(json);
							}else {
								JOptionPane.showMessageDialog(textArea, "La extensión del archivo no es valida", "La extensión del archivo no es valida", JOptionPane.ERROR_MESSAGE);
							}
						}
					}catch(ClassNotFoundException | SAXException | ParserConfigurationException cnfe) {
						System.out.println("No se encuentra la clase Empleado");
					}
				}catch(IOException e) {
					System.out.println("Archivo no encontrado");
				}
			}
		});
		select.setBounds(465, 9, 89, 23);
		panel.add(select);
		
		JLabel lblSeleccinArchivo = new JLabel("Selecci\u00F3n File .obj");
		lblSeleccinArchivo.setBounds(10, 11, 89, 18);
		panel.add(lblSeleccinArchivo);
		
		textField = new JTextField();
		textField.setBounds(121, 10, 334, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 203, 564, 25);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("JSON");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((f == null) || (f.getName().equals(""))) {
					JOptionPane.showMessageDialog(textArea, "No hay un archivo valido seleccionado", "No hay un archivo valido seleccionado", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						if(getExtension(f).equals(".json")) {
							JOptionPane.showMessageDialog(textArea, "El archivo seleccionado ya es JSON", "El archivo seleccionado ya es JSON", JOptionPane.ERROR_MESSAGE);
						}else {
							File faux = null;
							if(getExtension(f).equals(".obj")) {
								faux = ObjetosAJson(f);
								textArea_1.setText(leerJson(faux));
								textField.setText(f.getCanonicalPath());
							}else if(getExtension(f).equals(".xml")) {
								faux = XmlAJson(f);
								textArea_1.setText(leerJson(faux));
								textField.setText(f.getCanonicalPath());
							}else {
								JOptionPane.showMessageDialog(textArea, "No se reconoce la extension del archivo", "No se reconoce la extension del archivo", JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (IOException | ClassNotFoundException | SAXException | ParserConfigurationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(0, 0, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnXml = new JButton("XML");
		btnXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((f == null) || (f.getName().equals(""))) {
					JOptionPane.showMessageDialog(textArea, "No hay un archivo valido seleccionado", "No hay un archivo valido seleccionado", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						if(getExtension(f).equals(".xml")) {
							JOptionPane.showMessageDialog(textArea, "El archivo seleccionado ya es XML", "El archivo seleccionado ya es XML", JOptionPane.ERROR_MESSAGE);
						}else {
							File faux2 = null;
							if(getExtension(f).equals(".obj")) {
								faux2 = ObjetosAXml(f);
								textArea_1.setText(leerXml(faux2));
								textField.setText(f.getCanonicalPath());
							}else if(getExtension(f).equals(".json")) {
								faux2 = JsonAXml(f);
								textArea_1.setText(leerXml(faux2));
								textField.setText(f.getCanonicalPath());
							}else {
								JOptionPane.showMessageDialog(textArea, "No se reconoce la extension del archivo", "No se reconoce la extension del archivo", JOptionPane.ERROR_MESSAGE);
							}	
						}
					} catch (IOException | ClassNotFoundException | ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException | SAXException e1) {
						e1.printStackTrace();
					}					
				}
			}
		});
		btnXml.setBounds(99, 0, 89, 23);
		panel_1.add(btnXml);
		
		textArea = new JTextArea();
		textArea.setEditable(false);	
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 56, 564, 136);
		contentPane.add(scroll);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		JScrollPane scroll_A1 = new JScrollPane(textArea_1);
		scroll_A1.setBounds(10, 239, 564, 161);
		contentPane.add(scroll_A1);
	}
	public static String getExtension(File f) throws IOException {
		String ext = f.getCanonicalPath();				
		return ext.substring(ext.lastIndexOf("."), ext.length());
	}	
	public static String leerObjetos(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		String objs ="";
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream(f));
		Empleado e;
		try {
			while(true) {
				e = (Empleado) f_in.readObject();
				objs += "Nombre: " + e.getNombre() + "\n" + "Teléfono: " + e.getTelf() + "\n" + "Sueldo: " + e.getSueldo() + "\n\n";
			}
		}catch(EOFException eof) {
			f_in.close();
		}
		return objs;
	}
	public static String leerXml(File f) throws SAXException, IOException, ParserConfigurationException {
		String xmls = "";
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		
		Element root = (Element) doc.getChildNodes().item(0);
		xmls += "<" + root.getNodeName() + ">" +"\n\t";
		NodeList empleados = root.getElementsByTagName("empleado");
		
		for(int i = 0; i < empleados.getLength(); i++) {
			Element empleado = (Element) empleados.item(i);
			xmls += "<" + empleado.getNodeName() + ">" +"\n\t\t"
					+"<"+empleado.getElementsByTagName("nombre").item(0).getNodeName()+">"+ empleado.getElementsByTagName("nombre").item(0).getFirstChild().getNodeValue() +"</"+empleado.getElementsByTagName("nombre").item(0).getNodeName()+">"+ "\n\t\t"
					+"<"+empleado.getElementsByTagName("telf").item(0).getNodeName()+">" + empleado.getElementsByTagName("telf").item(0).getFirstChild().getNodeValue() +"</"+empleado.getElementsByTagName("telf").item(0).getNodeName()+">"+"\n\t\t"
					+"<"+empleado.getElementsByTagName("sueldo").item(0).getNodeName()+">" + empleado.getElementsByTagName("sueldo").item(0).getFirstChild().getNodeValue()+"</"+empleado.getElementsByTagName("sueldo").item(0).getNodeName()+">" + "\n\t"
					+"</" + empleado.getNodeName() + ">" +"\n\t";
		}
		xmls = xmls.substring(0, xmls.length()-1);
		xmls += "<" + root.getNodeName()+ ">";
		return xmls;
	}
	public static String leerJson(File f) throws FileNotFoundException {
		String jsons = "";
		java.io.FileInputStream j_in = new FileInputStream(f);
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(j_in));
		final Gson gson = new Gson();
		final java.lang.reflect.Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> empleados = gson.fromJson(bufferedReader, tipoLista);
		final String represerntacionJSON = gson.toJson(empleados);
		jsons = represerntacionJSON;
		return jsons;
	}
	public static File ObjetosAXml(File f) throws FileNotFoundException, IOException, ClassNotFoundException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		File xml = null;
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream(f));
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element root = doc.createElement("empleados");
		doc.appendChild(root);
		
		Empleado e;
		
		try {
			while(true) {
				e = (Empleado) f_in.readObject();
				
				Element empleado = doc.createElement("empleado");
				
				Element nombre = doc.createElement("nombre");
				nombre.appendChild(doc.createTextNode(e.getNombre()));
				empleado.appendChild(nombre);
				
				Element telf = doc.createElement("telf");
				telf.appendChild(doc.createTextNode(String.valueOf(e.getTelf())));
				empleado.appendChild(telf);
				
				Element sueldo = doc.createElement("sueldo");
				sueldo.appendChild(doc.createTextNode(String.valueOf(e.getSueldo())));
				empleado.appendChild(sueldo);
				
				root.appendChild(empleado);				
			}
		}catch(EOFException eof) {
			f_in.close();
		}
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("archivos/Empleados_o_x.xml"));		
		trans.transform(source, result);
		xml = new File("archivos/Empleados_o_x.xml");
		return xml;
	}
	public static File ObjetosAJson(File f) throws FileNotFoundException, IOException, ClassNotFoundException{
		File jsons = null;
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream(f));
		String jsonEmpleados = "";
		
		Empleado e;
		
		try {
			while(true) {
				e = (Empleado) f_in.readObject();
				
				jsonEmpleados += "{" + "\"nombre\":\""  + e.getNombre() + "\","
									+ "\"telf\":\""  + String.valueOf(e.getTelf()) + "\","
									+ "\"sueldo\":\"" + String.valueOf(e.getSueldo()) + "\""
									+ "},";
			}
		}catch(EOFException eof) {
			f_in.close();
		}
		
		jsonEmpleados = jsonEmpleados.substring(0, jsonEmpleados.length()-1);
		jsonEmpleados = "[" + jsonEmpleados + "]";
		//System.out.println(jsonEmpleados);
		final Gson gson = new Gson();
		final java.lang.reflect.Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> posts = gson.fromJson(jsonEmpleados, tipoLista);
		final Writer w_json = new FileWriter("./archivos/Empleados_o_j.json");		
		final String representacionJSON = gson.toJson(posts);		
		w_json.write(representacionJSON);		
		w_json.close();
		jsons = new File("./archivos/Empleados_o_j.json");
		return jsons;
	}
	public static File XmlAJson(File f) throws SAXException, IOException, ParserConfigurationException {
		File xml = null;
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./archivos/Empleados_o_x.xml");
		
		final Writer f_out = new FileWriter("./archivos/Empleados_x_j.json");
		
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
		final java.lang.reflect.Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> emp = gson.fromJson(jsonEmpleados, tipoLista);
		final String JSON = gson.toJson(emp);
		f_out.write(JSON);
		f_out.close();
		xml = new File("./archivos/Empleados_x_j.json");
		return xml;
	}
	public static File JsonAXml (File f) throws ParserConfigurationException, FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		File json = null;
		FileInputStream f_in = new FileInputStream("./archivos/Empleados_o_j.json");
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(f_in));

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		Element root = doc.createElement("empleados");
		doc.appendChild(root);
		
		final Gson gson = new Gson();
		final java.lang.reflect.Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
		final List<Empleado> empleados = gson.fromJson(bufferedReader, tipoLista);		
		
		for(Empleado e: empleados) {
			
			Element empleado = doc.createElement("empleado");
			
			Element nombre = doc.createElement("nombre");
			nombre.appendChild(doc.createTextNode(e.getNombre()));
			empleado.appendChild(nombre);
			
			Element telf = doc.createElement("telf");
			telf.appendChild(doc.createTextNode(String.valueOf(e.getTelf())));
			empleado.appendChild(telf);
			
			Element sueldo = doc.createElement("sueldo");
			sueldo.appendChild(doc.createTextNode(String.valueOf(e.getSueldo())));
			empleado.appendChild(sueldo);
			
			root.appendChild(empleado);			
		}
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("archivos/Empleados_j_x.xml"));
		trans.transform(source, result);
		json = new File("archivos/Empleados_j_x.xml");
		return json;
	}
}
