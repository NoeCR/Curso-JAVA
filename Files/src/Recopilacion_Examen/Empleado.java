package Recopilacion_Examen;
import java.io.Serializable;


public class Empleado implements Serializable{

	private static final  long serialVersionUID = 1L;
	private String nombre;	
	private long telf;
	private double sueldo;
	
	public Empleado(String nombre,long telf, double sueldo) {
		this.nombre = nombre;
		this.telf = telf;
		this.sueldo = sueldo;	
	}
	public Empleado(Empleado e) {
		this.nombre = e.getNombre();
		this.telf = e.getTelf();
		this.sueldo = e.getSueldo();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelf() {
		return telf;
	}

	public void setTelf(long telf) {
		this.telf = telf;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public void display() {		
		System.out.println("Nombre: " + nombre + "\n"  + "Telefono: " + telf + "\n"  + "Sueldo: " + sueldo + "\n");
	}
}
