package Ejemplos_t3;
import java.io.Serializable;

public class Empleado implements Serializable {

	private static final long serialVersionUID = 2L;
	private int num=0;
	private String nombre=null;
	private int departamento=0;
	private int edad=0;
	private double sueldo=0.0;
	private String localidad = null;

	public Empleado(){
	}

	public Empleado(int num, String nombre, int departamento, int edad, double sueldo){

		this.num = num;
		this.nombre = nombre;
		this.departamento = departamento;
		this.edad = edad;
		this.sueldo = sueldo;
		
	}

	public int getNum(){
		return this.num;
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getDepartamento(){
		return this.departamento;
	}

	public int getEdad(){
		return this.edad;
	}

	public double getSueldo(){
		return this.sueldo;
	}
	public void display() {
		
		System.out.println("Número: " + num + "\n" + "Nombre: " + nombre +  "\n" + "Departamento: " +departamento + "\n"+ "Edad: " + edad + "\n" +"Sueldo: " + sueldo);
	}
}