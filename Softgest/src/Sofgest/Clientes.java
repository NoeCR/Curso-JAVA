package Sofgest;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;

/**
 * Escriviu aquí una descripcìó de la classe Clientes
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Clientes {
    private String nombre;
	private String apellidos;
    private String dni;
    private String mail;
    private int edad;    
       
        
    /**
     * Mètode constructor per a objectes de la classe Clientes
     */
    public Clientes(String nombre,String apellidos, String dni, String mail, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.mail = mail;
        this.edad = edad;
    }
    public Clientes() throws IOException {
    	ArrayList<List> clientes = new ArrayList<List>();
    	//clientes.add(getClientes());
    	clientes.add(ImportClients.getClientes());
    	for(List cliente : clientes) {
    		System.out.println(cliente);
    	}
    
    }


	@Override
	public String toString() {
		return "Clientes [apellidos=" + apellidos + ", dni=" + dni + ", mail=" + mail + ", edad=" + edad + ", nombre="
				+ nombre + "]";
	}
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

}
 

