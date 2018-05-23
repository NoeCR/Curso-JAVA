package Ejemplos_t1;
import javax.swing.*;

public class EjemploJDialog extends JFrame{

	public EjemploJDialog() {
		super("Ejemplo ventana con dialogo!");
		setSize(500,500);
		JDialog cuadroDialogo = new JDialog(this,true);
		cuadroDialogo.setSize(200, 200);
		cuadroDialogo.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EjemploJDialog().setVisible(true);				
			}
		});
		
		
		
	}
}
