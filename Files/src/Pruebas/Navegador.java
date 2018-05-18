package Pruebas;


import java.awt.EventQueue;

import java.io.File;

import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.io.IOException;
import java.text.DateFormat;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Navegador {

	private JFrame frame;
	private JTextField seleccion;
	private JLabel lblDirectorio;
	private File f = File.listRoots()[0];;
	private ArrayList<File> ficheros = new ArrayList<File>();
	private JTextArea txtrResultado;
	private JButton ir_selec;
	private JButton volver;
	private JScrollPane scrollPane;
	private JButton permisos;
	private JButton lista;
	boolean listado = true;
	DateFormat formatter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navegador window = new Navegador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Navegador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("German-Browser");
		frame.setBounds(100, 100, 816, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblDirectorio = new JLabel("directorio");
		lblDirectorio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDirectorio.setBounds(20, 11, 536, 22);
		frame.getContentPane().add(lblDirectorio);
		
		ir_selec = new JButton("GO");
		ir_selec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				adelante();
			}
		});
		ir_selec.setBounds(621, 13, 70, 23);
		frame.getContentPane().add(ir_selec);
		
		volver = new JButton("BACK");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				atras();
			}
		});
		volver.setBounds(701, 13, 70, 23);
		frame.getContentPane().add(volver);
		
		seleccion = new JTextField("");
		seleccion.setBounds(566, 13, 45, 23);
		frame.getContentPane().add(seleccion);
		seleccion.setColumns(10);
		
		txtrResultado = new JTextArea();
		txtrResultado.setText("resultado");
		txtrResultado.setBounds(20, 299, 670, 153);
		//frame.getContentPane().add(txtrResultado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 751, 328);
		frame.getContentPane().add(scrollPane);
		
		permisos = new JButton("Detalles");
		permisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado = false;
				lista.setEnabled(true);
				permisos.setEnabled(false);
				inicio2();
			}
		});
		permisos.setBounds(577, 394, 92, 23);
		frame.getContentPane().add(permisos);
		
		lista = new JButton("Lista");
		lista.setEnabled(false);
		lista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado = true;
				lista.setEnabled(false);
				permisos.setEnabled(true);
				inicio2();
			}
		});
		lista.setBounds(679, 394, 92, 23);
		frame.getContentPane().add(lista);
		inicio2();
	}
	
	public void inicio2() {
		
		ficheros.clear();
		String padre = null;
		String hijos = "";
		int n = 0;
		formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM ,Locale.getDefault());
		
		try {
			padre = f.getCanonicalPath();
			lblDirectorio.setText(padre);
			if (listado) {
				hijos = getLista(n, hijos);
			}
			else {
				hijos = getDetalles(n, hijos);
			}
			txtrResultado.setText(hijos);
			scrollPane.setViewportView(txtrResultado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adelante() {
		
		int select = 0;
		if (!seleccion.getText().equals("")) {
			select = Integer.parseInt(seleccion.getText());
		}
		if( select > ficheros.size() || select < 1) {
			JOptionPane.showMessageDialog(null, "Introduce un valor entre 1 y " + ficheros.size());
			
		}
		else {
			if(ficheros.get(select-1).canRead()) {
				if (ficheros.get(select - 1).isDirectory()) {
					f = ficheros.get(select - 1);
				}
				else JOptionPane.showMessageDialog(null, "No es un directorio");
			}
			else JOptionPane.showMessageDialog(null, "No tienes permisos");			
		}
		seleccion.setText("");
		inicio2();
	}
	
	public void atras() {
		
		if (f.getParentFile() != null) {
			f = f.getParentFile();	
			seleccion.setText("");
			inicio2();
		}
	}
	
	public String getLista(int n, String hijos) {
		
		for (File e : f.listFiles()) {
			if (!e.isHidden()) {
				n++;
				ficheros.add(e);
				if (e.isFile())
					hijos += n + ".- " + e.getName() + " " + e.length() + " bytes\n";
				if (e.isDirectory())
					hijos += n + ".- " + e.getName() + " <Directorio>\n";
			}
		}
		return hijos;
	}
	
	public String getDetalles(int n, String hijos) {
		
		for (File e : f.listFiles()) {
			if (!e.isHidden()) {
				char data[] = {'-','-','-','-'};
				if(e.isDirectory()) data[0] = 'd';
				if(e.canRead()) data[1] = 'r';
				if(e.canWrite()) data[2] = 'w';
				if(e.canExecute()) data[3] = 'x';
				String permisos = new String(data);
				n++;
				ficheros.add(e);
				hijos += (n + ".- \t" + permisos +  "\t" + String.format("%-15d", e.length()) + "\t" + formatter.format(e.lastModified()) +  "\t" + e.getName() + "\n");	
			}
		}
		return hijos;
		
	}
}