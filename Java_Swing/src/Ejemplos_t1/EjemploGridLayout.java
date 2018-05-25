package Ejemplos_t1;
import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.Container;

public class EjemploGridLayout extends JFrame{
	final Container container = getContentPane();
	
	public EjemploGridLayout() {
		int x = 3;
		int y = 3;
		container.setLayout(new GridLayout(x,y));
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				container.add(new JButton(i + "x" + j));
			}
		}
		setSize(350,250);
		setTitle("Prueba Grid Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EjemploGridLayout().setVisible(true);
			}
		});
	}

}
