package Pruebas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CrearObjetoDisco {
	public static void main(String[] args) throws IOException{
		
		ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("./archivos/Disco.obj"));
		long ean = 	12345678910L;
		String nombre = "KASE-O";
		String titulo = "El Círculo";
		String genero = "Hip Hop nacional";
		String estreno = "23/09/2016";
		String sello = "BOA Musica";
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		String info = "Después de que sus dos compañeros del grupo Violadores del Verso ya sacaran sus discos en solitario hace años, y tras lanzar un primer maxi llamado \"Previo\", Kase.O lanza un nuevo trabajo en formato LP, lejos del rap con banda que caracterizó \"Jazz magnetism\". El álbum se llama \"El círculo\" y aparece a la venta el 23 de Septiembre, componiéndose por 17 cortes en los que aparecen colaboraciones de Xhelazz, Sho-Hai, Hermano L, Shabu One Shant, McKlopedia, Najwa y Violadores del verso al completo.";
		
		Disco d;
		d = new Disco ( 1 , ean, nombre, titulo, genero, estreno,sello,canciones, info);		
		
		String[] nombresc = {"Intro (El Círculo)", "Esto No Para", "Yemen", "Triste 5.", "Viejos Ciegos", "Interludio Quieren Copiar", "Pavos Reales", "Mitad y Mitad con Najwa", "Mazas y Catapultas", "Amor Sin Cláusulas", "No Se Que Voy A Hacer", "Interludio Risoterapia", "Rap Superdotado con Violadores del Verso", "Repartiendo Arte", "Basureta", "Outro"};
		
		for(int i = 0; i<nombresc.length-1; i++) {
			canciones.add(new Cancion(d, nombresc[i]));
		}					
		d.display();
		f.writeObject(d);
		
		f.close();
	}
}