package Ejemplos;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LecturaRandomAccess {
	public static void main(String[] args) throws IOException{
		
		RandomAccessFile f_in = new RandomAccessFile("./archivos/Empleados_copy.dat", "r");
		DataOutputStream f_out = new DataOutputStream(new FileOutputStream("./archivos/Empleados_copy2.dat"));
		
		f_in.seek(56);
		try {
			while(true) {		
				f_out.writeInt(f_in.readInt());
				f_out.writeUTF(f_in.readUTF());
				f_out.writeInt(f_in.readInt());
				f_out.writeInt(f_in.readInt());
				f_out.writeDouble(f_in.readDouble());				
			}
		}catch(EOFException eof) {
			f_in.close();
			f_out.close();
		}	
	}
}
