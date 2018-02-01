package Cap01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CAplicacion extends javax.swing.JFrame {
	/** Metodo constructor que crea un formulario de la clase CAplicacion. */

	private JLabel jEtSaludo;
	private JButton jBtSaludo;

	public CAplicacion(){
		setSize(400, 400);
		setTitle("Aplicacion");
		initComponents();

	}
	/** Este metodo es llamado desde el constructor de la clase CAplicacion. */
	private void initComponents() {
		getContentPane().setLayout(GridLayout(2,1));
		jEtSaludo = new JLabel();
		jEtSaludo.setText("Etiqueta");
		jEtSaludo.setHorizontalAlignment(SwingConstants.CENTER);
		jEtSaludo.setFont(new Font("Dialog", 1, 18));
		getContentPane().add(jEtSaludo);
		jEtSaludo.setBounds(40, 36, 204, 30);

		jBtSaludo = new JButton();
		jBtSaludo.setText("Haga click aquí");
		jBtSaludo.setToolTipText("boton de pulsación");
		jBtSaludo.setMnemonic('c');
		jBtSaludo.setHorizontalAlignment(SwingConstants.CENTER);
		jBtSaludo.setFont(new Font("Dialog", 1, 18));
		getContentPane().add(jBtSaludo);
		jBtSaludo.setBounds(40, 90, 204, 30);


		jBtSaludo.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				jBtSaludoActionPerformered(evt);
			}
		});
		addWindowListener(new java.awt.event.WindowAdapter() 
		{
			public void windowClosing (java.awt.event.WindowEvent evt) 
			{
				exitForm(evt);
			}
		}
				);
	}
	private LayoutManager GridLayout(int i, int j) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
	private void exitForm(java.awt.event.WindowEvent evt) {
		System.exit(0);
	}
	private void jBtSaludoActionPerformered(ActionEvent evt) {
		float rojo = (float)Math.random();
		float verde = (float)Math.random();
		float azul = (float)Math.random();
		jEtSaludo.setForeground(new Color(rojo, verde, azul));
		jEtSaludo.setText("Hola Mundo!");
	}
	public static void main(String[] args) {
		try {
			// Aspecto de la interface gráfica
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e) {
			System.out.println("No se pudo establecer el aspecto deseado: " + e);
		}
		new CAplicacion().setVisible(true);

	}
	//Declaracion de variables
}
