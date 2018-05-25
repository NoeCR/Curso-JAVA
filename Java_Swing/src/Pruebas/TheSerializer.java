package Pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class TheSerializer extends JFrame {

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
					 JOptionPane.showMessageDialog(textArea, "Nombre de archivo inv�lido", "Nombre de archivo inv�lido", JOptionPane.ERROR_MESSAGE);
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
						if(f.getCanonicalPath().endsWith(".xml")) {
							JOptionPane.showMessageDialog(textArea, "El archivo seleccionado ya es XML", "El archivo seleccionado ya es XML", JOptionPane.ERROR_MESSAGE);
						}else {
							File f2 = convertirAXml(f);
							textArea_1.setText(leerXml(f2));
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
	public static String leerObjetos(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		String objs ="";
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream(f));
		Empleado e;
		try {
			while(true) {
				e = (Empleado) f_in.readObject();
				objs += "Nombre: " + e.getNombre() + "\n" + "Tel�fono: " + e.getTelf() + "\n" + "Sueldo: " + e.getSueldo() + "\n\n";
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
	public static File convertirAXml(File f) throws FileNotFoundException, IOException, ClassNotFoundException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
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
}
