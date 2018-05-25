package Ejemplos_t1;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class EjemploFlowLayout extends JFrame{
	final JPanel panel = new JPanel();
	final JButton btn1 = new JButton("boton 1");
	final JButton btn2 = new JButton("boton 2");
	final JButton btn3 = new JButton("boton 3");		
	
	public 	EjemploFlowLayout() {
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		setContentPane(panel);
		setSize(400,150);
		setTitle("Prueba de FlowLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EjemploFlowLayout().setVisible(true);
			}
		});
	}

}
