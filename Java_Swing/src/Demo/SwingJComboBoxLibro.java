package Demo;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * A Swing program that demonstrates how to create and use JComboBox component.
 * 
 * @author www.codejava.net
 * 
 */
public class SwingJComboBoxLibro extends JFrame {

	private JButton buttonSelect = new JButton("Select");
	private JButton buttonRemove = new JButton("Remove");
	private JLabel labelId = new JLabel();
	public SwingJComboBoxLibro() {
		super("Swing JComboBox Libros");

		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		// Crear una lista de objetos libros
		Libro[] libros = new Libro[] {
		         new Libro(1, "La ciudad de los prodigios", "Eduardo Mendoza", "Seix Barral", 576, 1986),
		         new Libro(2, "Aventuras de Oliver Twist", "Charles Dickens", "Alfaguara", 577, 1837),
		         new Libro(3, "Los hombres que no amaban a las mujeres", "Stieg Larsson", "Círculo de lectores", 666, 2005)
		    };
		//Creamos el modelo pasandole el array de libros
		MyComboBoxModel myModel = new MyComboBoxModel(libros);
		
		//Y creamos el combo con este modelo. Así de sencillo
		final JComboBox<Libro> listaDeLibros = new JComboBox<Libro>(myModel);
		
		// customize some appearance:
		listaDeLibros.setForeground(Color.BLUE);
		listaDeLibros.setFont(new Font("Arial", Font.BOLD, 14));
		listaDeLibros.setMaximumRowCount(10);
		
		
		// add an event listener for the combo box
		listaDeLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				@SuppressWarnings("unchecked")
				// En programación orienta a eventos, debemos obtener la fuente que ha generado el evento
				// En este caso, el combo
				JComboBox<Libro> combo = (JComboBox<Libro>) event.getSource();
				//Ahora que tenemos el combo, getSelectedItem() nos devuelve un objeto Libro!!
				Libro selectedBook = (Libro) combo.getSelectedItem();
				//Y ya podemos acceder a todas sus getters
				labelId.setText(Integer.toString(selectedBook.getId()));
				
				
			}
		});

		// add event listener for the button Select 
		buttonSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Libro selectedBook = (Libro) listaDeLibros.getSelectedItem();
				
				JOptionPane.showMessageDialog(SwingJComboBoxLibro.this,
						"Has seleccionado : " + selectedBook);
			}
		});

		// add event listener for the button Remove
		buttonRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Libro selectedBook = (Libro) listaDeLibros.getSelectedItem();
				listaDeLibros.removeItem(selectedBook);
			}
		});

		// add components to this frame
		add(listaDeLibros);
		add(buttonSelect);
		add(buttonRemove);
		add(labelId);
		
		//Como no hemos fijado las dimensiones del JFrame, llamamos a pack()
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		//El programa main es siempre igual
		//https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SwingJComboBoxLibro().setVisible(true);
			}
		});
	}
}