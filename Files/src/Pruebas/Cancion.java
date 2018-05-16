package Pruebas;

import java.io.Serializable;

public class Cancion implements Serializable{
	private Disco disco;
	private String nombre;
	
	
	public Cancion (Disco disco, String nombre) {
		this.disco = disco;
		this.nombre = nombre;
	}
	
	public Disco getDisco() {
		return disco;
	}
	public void setDisco(Disco disco) {
		this.disco = disco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
