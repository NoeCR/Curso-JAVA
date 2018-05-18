package Ejemplos_XML_JSON;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializarObjetos {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
    	//Leer un archivo como objetos
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("./archivos/Post.obj"));

        Post p;
        try {
            while (true) {
                p = (Post) f.readObject();
                System.out.println("From: " + p.getFrom());
                System.out.println("to: " + p.getTo());
                System.out.println("Asunto: " + p.getAsunto());
                System.out.println("Mensaje: " + p.getTexto());
                System.out.println();
            }

        } catch (EOFException eof) {
            f.close();
        }
    }
}