package Ejemplos_t1;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PruebaJTextFiled extends JFrame{

	public PruebaJTextFiled() {
		setTitle("DATOS");
		setSize(300, 200);
		JLabel lbl1 = new JLabel("Nombre");
		JTextField txt1 = new JTextField(18);
		
		JLabel lbl2 = new JLabel("Edad");
		JTextField txt2 = new JTextField(10);
		
		Container contentpane = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		
		panel.add(lbl1);
		panel.add(txt1);
		panel.add(lbl2);
		panel.add(txt2);
		//panel.add(new javax.swing.JPasswordFiled(10));
		//panel.add(new JButton("CLick aquì"));
		contentpane.add(panel);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PruebaJTextFiled().setVisible(true);
			}
		});

	}
}
