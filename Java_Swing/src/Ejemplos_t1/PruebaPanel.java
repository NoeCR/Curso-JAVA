package Ejemplos_t1;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PruebaPanel extends JFrame{
	
	public PruebaPanel() {
		
		setTitle("Prueba Panel");
		setSize(300,200);
		
		Container contentpane = getContentPane();
		
		JPanel panel = new JPanel();
		
		contentpane.add(panel);
		
		panel.setBackground(Color.RED);
		
		panel.add(new JButton("Click aquí"));
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PruebaPanel().setVisible(true);
			}
		});
	}
}
