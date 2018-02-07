package Sofgest;


import java.util.Calendar;
import java.util.ArrayList;

/**
 * Escriviu aquí una descripcìó de la classe Historico
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Historico {

	private Calendar fecha;
	private ArrayList<Venta> ventas;
	/**
	 * Mètode constructor per a objectes de la classe Historico
	 */
	public Historico() {
		this.ventas = new ArrayList<>();
		this.fecha = Calendar.getInstance();
	}
	@Override
	public String toString() {
		return "Historico [fecha=" + fecha + ", ventas=" + ventas + "]";
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
}
