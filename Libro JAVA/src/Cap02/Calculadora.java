package Cap02;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calculadora extends javax.swing.JFrame {

		private JTextField jtfprincipal; 
	    private JButton btn0,btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	    private JButton clear;
	    private JButton reset;
	    private JButton dot;
	    private JButton sum, rest, mult, div, mod;
	    private JButton result;
	
	
	public Calculadora() {
		setSize(300,300);
		setTitle("Calculadora");//Titulo del form 
		initComponents(); // Iniciar componentes	
		
	}
	
	private void initComponents() {
		
		jtfprincipal = new javax.swing.JTextField();
		btn0 = new javax.swing.JButton();
		btn1 = new javax.swing.JButton();
		btn2 = new javax.swing.JButton();
		btn3 = new javax.swing.JButton();
		btn4 = new javax.swing.JButton();
		btn5 = new javax.swing.JButton();
		btn6 = new javax.swing.JButton();
		btn7 = new javax.swing.JButton();
		btn8 = new javax.swing.JButton();
		btn9 = new javax.swing.JButton();
		clear = new javax.swing.JButton();
		reset = new javax.swing.JButton();
		sum = new javax.swing.JButton();
		rest = new javax.swing.JButton();
		mult = new javax.swing.JButton();
		div = new javax.swing.JButton();
		mod = new javax.swing.JButton();
		result = new javax.swing.JButton();
		dot = new javax.swing.JButton();
		
		// establece el administrador de diseño null
		getContentPane().setLayout(null);
	}

	public static void main(String[] args) {
		
		
		
		
	}

}
