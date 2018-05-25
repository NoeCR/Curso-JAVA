package Ejemplos_t1;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EjemploLayoutNull extends JFrame{
	final JButton boton = new JButton("CLick");
	
	public EjemploLayoutNull() {
		setSize(300,200);
		Container contenedor = getContentPane();
		contenedor.setLayout(null);
		contenedor.add(boton);
		boton.setBounds(50, 100,80,60);
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EjemploLayoutNull().setVisible(true);
			}
		});
	}
}
