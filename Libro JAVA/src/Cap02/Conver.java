package Cap02;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Conver extends javax.swing.JFrame {
	// Declaracion de variables de la clase
	private JLabel jlbGradosC;
	private JTextField jtfGradosC;
	private JLabel jlbGradosF;
	private JTextField jtfGradosF;
	private JButton jbtAceptar;
	private Object objJTextField;

	/** Crear un nuevo formulacio Conver */ 
	public Conver() {
		setSize(300,200);//Tamaño del formulario
		setTitle("Conversion de temperaturas");//Titulo del form
		initComponents(); // Iniciar componentes	
	}
	
	/**
	 * Este metodo es llamado por el constructor para iniciar el formulario
	 */
	private void initComponents() {
		// creamos los objetos del formulario
		jlbGradosC = new javax.swing.JLabel();
		jtfGradosC = new javax.swing.JTextField();
		jlbGradosF = new javax.swing.JLabel();
		jtfGradosF = new javax.swing.JTextField();
		jbtAceptar = new javax.swing.JButton();
		
		KeyListener kl = new KeyAdapter() {
			public void KeyTyped(KeyEvent evt) {
				jtfGradosKeyTyped(evt);
			}
		};
		jtfGradosC.addKeyListener(kl);
		//.....
		jtfGradosF.addKeyListener(kl);
		// establece el administrador de diseño null
		getContentPane().setLayout(null);
		//Manejador de eventos asociado con el formulario
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm(evt);
			}
		}
		);
		// manejador de eventos asociado con el boton
		jbtAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				jbtAceptarActionPerformed(evt);
			}
		});
		//Etiqueta "Grados centigrados"
		jlbGradosC.setText("Grados centígrados");
		getContentPane().add(jlbGradosC);
		jlbGradosC.setBounds(12, 28, 116, 24);
		//Caja de texto para los grados centígrados
		jtfGradosC.setText("0.00");
		jtfGradosC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		getContentPane().add(jtfGradosC);
		jtfGradosC.setBounds(132, 28, 144, 24);
		//Etiqueta "Grados fahrenheit"
		jlbGradosF.setText("Grados Fahrenheit");
		getContentPane().add(jlbGradosF);
		jlbGradosF.setBounds(12, 68, 104, 24);
		//Caja de texto para los grados fahrenheit
		jtfGradosF.setText("32.00");
		jtfGradosF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		getContentPane().add(jtfGradosF);
		jtfGradosF.setBounds(132, 72, 144, 24);
		//Botón Aceptar
		jbtAceptar.setText("Aceptar");
		jbtAceptar.setMnemonic('A');
		getRootPane().setDefaultButton(jbtAceptar);
		getContentPane().add(jbtAceptar);
		jbtAceptar.setBounds(132, 120, 144, 24);
		
	}
	/**
	 * metodo para salir de la aplicacion
	 * @param evt
	 */
	private void exitForm(java.awt.event.WindowEvent evt) {
		System.exit(0);
	}
	private void jtfGradosKeyTyped(KeyEvent evt) {
		objJTextField = evt.getSource(); // Objeto que produjo el evento
	}
	
	private void jbtAceptarActionPerformed (ActionEvent evt) {
		try {
			double grados;
			//Si escribio en la caja de texto grados centigrados..
			if(objJTextField == jtfGradosC) {
				grados = Double.parseDouble(jtfGradosC.getText()) * 9.0 / 5.0 + 32;
				String texto = String.format("%.2f", grados); //redondea los decimales
				jtfGradosF.setText(texto);
			}
			//Si se escribio en la caja de grados fahrenheit ....
			if(objJTextField == jtfGradosF) {
				grados = (Double.parseDouble(jtfGradosC.getText())-32) * 5.0 / 9.0;
				String texto = String.format("%.2f", grados); //redondea los decimales
				jtfGradosC.setText(texto);
			}
		}
		catch (NumberFormatException e){
			jtfGradosC.setText("0.00");
			jtfGradosF.setText("32.00");
		}
	}
	
	public static void main(String[] args) {
		// Establece el aspecto Nimbus para la interface grafica, si no sta disponible se queda con el que trae por defecto
		try {
			for(javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
				if("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getName());
					break;
				}
			}
		}
		catch (Exception e) {
			System.out.println("no se pudo establecer el aspecto deseado: " + e);
		}
		new Conver().setVisible(true);
	}
		//Declaracion de las variables miembro de la clase
}
