package Pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Tienda Online");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("47px"),
				ColumnSpec.decode("46px"),
				ColumnSpec.decode("24px"),
				ColumnSpec.decode("89px"),
				ColumnSpec.decode("20px"),
				ColumnSpec.decode("130px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				RowSpec.decode("23px"),
				RowSpec.decode("20px"),
				RowSpec.decode("20px"),
				RowSpec.decode("23px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("48px"),}));
		
		JLabel txuser = new JLabel("New label");
		contentPane.add(txuser, "2, 4, left, center");
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "4, 4, left, top");
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action);
		contentPane.add(btnNewButton_1, "6, 4, fill, top");
		
		textField = new JTextField();
		contentPane.add(textField, "2, 6, 5, 1, fill, top");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, "2, 8, left, center");
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2, "4, 8, left, top");
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3, "6, 8, fill, top");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "2, 10, 5, 1, fill, top");
		textField_1.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, "2, 12, 5, 1, fill, fill");
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
