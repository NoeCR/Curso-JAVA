package Pruebas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setBounds(0, 0, 101, 36);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(111, 19, 230, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(48, 69, 353, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTelfono = new JLabel("Teléfono :");
		lblTelfono.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTelfono.setBounds(0, 0, 101, 36);
		panel_1.add(lblTelfono);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 19, 230, 19);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(48, 132, 353, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSueldo = new JLabel("Sueldo : ");
		lblSueldo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSueldo.setBounds(0, 0, 101, 36);
		panel_2.add(lblSueldo);
		
		textField_2 = new JTextField();
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
				//addEmpleado(textField.getText(),textField_1.getText(),textField_2.getText());
				empleados.add(new Empleado(textField.getText(), Long.parseLong(textField_1.getText()), Double.parseDouble(textField_2.getText())));
				TheSerializer.showTemporalObjects(empleados);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
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
			}
		});
		btnNewButton_2.setBounds(244, 12, 97, 25);
		panel_3.add(btnNewButton_2);
		setTitle("Agregar objetos al nuevo fichero");
		setVisible(true);
	}
	private ArrayList<Empleado> addEmpleado(String nombre, String telf, String sueldo){
		
		empleados.add(new Empleado(nombre, Long.parseLong(telf), Double.parseDouble(sueldo)));
		return empleados;
	}
}
