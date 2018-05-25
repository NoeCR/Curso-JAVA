package Demo;

import java.io.Serializable;

public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String autor;
	private String editorial;
	private int paginas;
	private int anyo;
	
	public Libro(int id, String titulo, String autor, String editorial, int paginas, int anyo) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.paginas = paginas;
		this.anyo = anyo;
				
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	@Override
	public String toString() {
		return titulo + " " + autor;
	}
}
