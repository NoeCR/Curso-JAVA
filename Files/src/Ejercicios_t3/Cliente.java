package Ejercicios_t3;

import java.io.Serializable;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String telf;
	private String dir;	

	public Cliente(String nombre,String telf,String dir) {
		this.nombre = nombre;
		this.telf = telf;
		this.dir = dir;		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}
	public void display() {
		System.out.println("Nombre: " + nombre + " Telefono: " + telf + " Dirección: " + dir);		
	}
}
