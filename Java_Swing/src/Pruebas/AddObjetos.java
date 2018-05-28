package Pruebas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddObjetos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static ArrayList<Empleado> empleados =  new ArrayList<Empleado>();

	/**
	 * Create the frame.
	 */
	public AddObjetos() {
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension monitorsize = pantalla.getScreenSize();
		int height = monitorsize.height;
		int width = monitorsize.width;
		setBounds(width/3, height/3, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 5, 353, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Name :");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setBounds(0, 0, 101, 36);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) arg0.consume(); {
					
				}
			}
		});
		textField.setBounds(111, 19, 230, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(48, 69, 353, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTelfono = new JLabel("Phone :");
		lblTelfono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTelfono.setBounds(0, 0, 101, 36);
		panel_1.add(lblTelfono);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c < '0' || c > '9') e.consume(); 
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(111, 19, 230, 19);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(48, 132, 353, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSueldo = new JLabel("Salary : ");
		lblSueldo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSueldo.setBounds(0, 0, 101, 36);
		panel_2.add(lblSueldo);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c < 46 || c > '9' || c == 47) e.consume(); 
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(111, 19, 230, 19);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(48, 203, 353, 36);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validation(textField.getText(),textField_1.getText(),textField_2.getText())){
					empleados.add(new Empleado(textField.getText(), Long.parseLong(textField_1.getText()), Double.parseDouble(textField_2.getText())));
					TheSerializer.showTemporalObjects(empleados);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
			}
		});
		btnNewButton.setBounds(125, 12, 107, 25);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnNewButton_1.setBounds(12, 12, 101, 25);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(empleados.size()>0) {
					try {
						TheSerializer.leerObjetos(TheSerializer.writeObjects(empleados));
						empleados.clear();
					} catch (IOException | ClassNotFoundException e1) {						
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "No hay ningun objeto introducido", "No hay ningun objeto introducido", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(244, 12, 97, 25);
		panel_3.add(btnNewButton_2);
		setTitle("Agregar objetos al nuevo fichero");
		setVisible(true);
	}
	public static void resetEmpleados() {
		empleados.clear();
	}
	private boolean validation(String nombre, String tefl, String sueldo) {
		boolean ok = false;
		if(nombre.equals("") || tefl.equals("") || sueldo.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos", "Por favor rellene todos los campos", JOptionPane.INFORMATION_MESSAGE);
		}else{
			ok = true;
		}
		return ok;
	}
}
