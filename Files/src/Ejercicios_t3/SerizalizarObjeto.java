package Ejercicios_t3;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerizalizarObjeto {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ObjectOutputStream f_out = new ObjectOutputStream(new FileOutputStream("./archivos/Clientes.obj",true));
		Cliente c = new Cliente("Marco","965874523","C/ Fortea nº39");
		
		
		f_out.writeObject(c);
		f_out.close();
	}
}
