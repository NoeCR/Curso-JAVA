package Ejemplos_t1;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class EjemploBorderLayout  extends JFrame{
	final JButton nort = new JButton("Norte");
	final JButton sud = new JButton("Sur");
	final JButton est = new JButton("Este");
	final JButton oest = new JButton("Oeste");
	final JButton cent = new JButton("Centro");
	final Container panel = getContentPane();
	
	
	public EjemploBorderLayout() {
		panel.add(nort, BorderLayout.NORTH);
		panel.add(sud, BorderLayout.SOUTH);
		panel.add(est, BorderLayout.EAST);
		panel.add(oest, BorderLayout.WEST);
		panel.add(cent, BorderLayout.CENTER);
		
		setSize(350,250);
		setTitle("Prueba BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EjemploBorderLayout().setVisible(true);
			}
		});

	}

}
