package Pruebas;
import java.util.ArrayList;
import java.io.Serializable;

public class Disco implements Serializable{
	private static final long serialVersionUID = 1L;
	private int num = 0;
	private long ean;
	private String autor;
	private String titulo;
	private String genero;
	private String estreno;
	private String sello;
	private ArrayList<Cancion> canciones = new  ArrayList<Cancion>();
	private String info;
	public Disco(int num, long ean, String autor, String titulo, String genero, String estreno, String sello, ArrayList<Cancion> canciones, String info) {
		this.num = num;
		this.ean = ean;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.estreno = estreno;
		this.sello = sello;
		this.canciones = canciones;
		this.info = info;
		
	}
	public void addCancion(Cancion c) {
		canciones.add(c);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public long getEAN() {
		return ean;
	}
	public void setEAN(long ean) {
		this.ean = ean;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstreno() {
		return estreno;
	}
	public void setEstreno(String estreno) {
		this.estreno = estreno;
	}
	public String getSello() {
		return sello;
	}
	public void setSello(String sello) {
		this.sello = sello;
	}
	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void display() {
		int count = 1;
		System.out.println("Disco: " + num + "\n"
				    +"Codigo EAN: " + ean + "\n"
					+ "Autor: " + autor + "\n"
					+  "Titulo: " + titulo + "\n"
					+ "Genero: " + genero + "\n"
					+ "Fecha de publicacion: " + estreno + "\n"
					+ "Sello Discografico: " + sello + "\n");
		for (Cancion c: canciones) {
			System.out.println("Pista: " + count + " Titulo: " + c.getNombre());
			count++;
		}
		System.out.println("\n");
	}
	
}
