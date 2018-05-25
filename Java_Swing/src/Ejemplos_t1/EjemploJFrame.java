package Ejemplos_t1;
import javax.swing.*;

public class EjemploJFrame extends JFrame{
	
	public EjemploJFrame(){
		this.setTitle("Hola!");
		this.setSize(300,200);
		
		setResizable(true);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
	        public void run() {
               new EjemploJFrame().setVisible(true);
            }

        });
	}
}
