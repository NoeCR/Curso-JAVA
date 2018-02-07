package Sofgest; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;

import java.util.Calendar;

/**
 * Escriviu aquí una descripcìó de la classe Clientes
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Clientes {

	private RichTextString nombre;
	private RichTextString apellidos;
    private RichTextString dni;
    private RichTextString mail;
    private double edad; 
    private double telefono;
       
        
    /**
     * Mètode constructor per a objectes de la classe Clientes
     */
    public Clientes(RichTextString nombre,RichTextString apellidos, RichTextString dni, RichTextString mail, double edad, double telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.edad = edad;
        this.dni = dni;  
        this.telefono = telefono;
    }
    public Clientes() throws IOException {
    	List sheetData = Import.getClientes();
    	for (int i = 1; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) {
				Cell cell = (Cell) list.get(j);
				if(j == 0) {
					this.nombre = cell.getRichStringCellValue();
				}else if(j ==1) {
					this.apellidos = cell.getRichStringCellValue();
				}else if(j ==2) {
					this.mail = cell.getRichStringCellValue();
				}else if(j ==3) {
					this.edad = cell.getNumericCellValue();
				}else if(j ==4) {
					this.dni = cell.getRichStringCellValue();
				}else if(j ==5) {
					System.out.println("Telefono: " + cell.getNumericCellValue());
				}				
			}			
		}
    
    }


    @Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", mail=" + mail + ", edad="
				+ edad + ", telefono=" + telefono + "]";
	}
    public RichTextString getNombre() {
		return nombre;
	}
	public void setNombre(RichTextString nombre) {
		this.nombre = nombre;
	}
	public RichTextString getApellidos() {
		return apellidos;
	}
	public void setApellidos(RichTextString apellidos) {
		this.apellidos = apellidos;
	}
	public RichTextString getDni() {
		return dni;
	}
	public void setDni(RichTextString dni) {
		this.dni = dni;
	}
	public RichTextString getMail() {
		return mail;
	}
	public void setMail(RichTextString mail) {
		this.mail = mail;
	}
	public double getEdad() {
		return edad;
	}
	public void setEdad(double edad) {
		this.edad = edad;
	}
	public double getTelefono() {
		return telefono;
	}
	public void setTelefono(double telefono) {
		this.edad = telefono;
	}

}
 
/*
 *     	ArrayList<List> clientes = new ArrayList<List>();
    	//clientes.add(getClientes());
    	clientes.add(Import.getClientes());
    	for(List cliente : clientes) {
    		System.out.println(cliente);
    	}
  */
 

