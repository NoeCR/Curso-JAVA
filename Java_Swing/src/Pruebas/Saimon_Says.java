package Pruebas;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import Demo.Libro;
import Demo.SwingJComboBoxLibro;

import java.util.Random;
import Ejemplos_t1.EjemploBorderLayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saimon_Says extends JFrame{
	final JButton btn1 = new JButton("1");
	final JButton btn2 = new JButton("2");
	final JButton btn3 = new JButton("3");
	final JButton btn4 = new JButton("4");
	final JButton btn5 = new JButton("5");
	final Container panel = getContentPane();
	private static String usernumber ="";
	private static String saimonnumber =randomNumber();
	
	public Saimon_Says() {
		panel.add(btn1, BorderLayout.NORTH);
		panel.add(btn2, BorderLayout.SOUTH);
		panel.add(btn3, BorderLayout.EAST);
		panel.add(btn4, BorderLayout.WEST);
		panel.add(btn5, BorderLayout.CENTER);
		
		setSize(350,250);
		setTitle("Saimon Dice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {	
			//al hacer click en el boton añade "1" al String del usuario
			usernumber += userNumber(1,evt);
			}
		});
	}

	public static void main(String[] args) {
		System.out.println(saimonnumber);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Saimon_Says().setVisible(true);				
							
			}
		});
		do {
			
		}while(usernumber.length()<10);
			System.out.println("El numero de usuario es: " + usernumber);

	}
	public static String randomNumber() {
		int[] num = new int[10];
		String numeros ="";
		for (int i = 0; i< num.length; i++) {
			num[i] = (int) (Math.random()*5)+1;
			numeros += String.valueOf(num[i]);
		}
		return numeros;
	}
	public static String userNumber(int num, ActionEvent evt) {
		int numero = num;
		String convert = "";
		if(numero < 0 || numero > saimonnumber.length()) {
			System.out.println("Error al introducir el numero, revisar programación Button!!");
		}else {
			convert = String.valueOf(numero);
		}
		return convert;
	}
}
