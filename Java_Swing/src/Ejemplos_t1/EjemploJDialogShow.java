package Ejemplos_t1;
import javax.swing.*;
public class EjemploJDialogShow {

	public static void main(String[] args) {
	String user = JOptionPane.showInputDialog(null, "user");
	String password = JOptionPane.showInputDialog(null,"password");
	
	
	if(user.equals("admin") && password.equals("1234")) {
		JOptionPane.showMessageDialog(null, "Login ok");
	}else {
		JOptionPane.showMessageDialog(null, "Login failed");
	}
  }
	

}
