package Ejemplos_t1;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;


public class PruebaCombo extends JFrame{

	public PruebaCombo() {
		setTitle("Selector!!!");
		setSize(300, 200);
		
		String[] opciones = {"Arriba", "Abajo", "Derecha", "Izquierda", "Todas"};
		
		JComboBox<String> cmblista = new JComboBox<String>(opciones);
		
		Container contentpane = getContentPane();
		
		JPanel panel = new JPanel();
		panel.add(cmblista);
		contentpane.add(panel);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PruebaCombo().setVisible(true);
			}
		});
	}

}
