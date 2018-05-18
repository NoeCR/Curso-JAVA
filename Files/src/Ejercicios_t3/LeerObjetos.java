package Ejercicios_t3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerObjetos {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream f_in = new ObjectInputStream(new FileInputStream("./archivos/Clientes_de_j_a_o.obj"));
		
		Cliente c;
		try {
			while(true) {
				c = (Cliente) f_in.readObject();
				c.display();
			}
		}catch(EOFException eof) {
			f_in.close();
		}
	}
}
