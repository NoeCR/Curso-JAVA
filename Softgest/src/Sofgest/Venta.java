package Sofgest;
import java.util.ArrayList;

/**
 * Escriviu aquí una descripcìó de la classe Venta
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Venta {
	private Clientes cliente;
	private Articulo art;
	private int cuantos;
	/**
	 * Mètode constructor per a objectes de la classe Venta
	 */
	public Venta(Clientes cliente, Articulo articulo, int cuantos) {
		this.cliente = cliente;
		this.art = articulo;
		this.cuantos = cuantos;
	}
	/**
	 * Metodo para mostrar el nombre y apellidos del cliente, el nombre y precio del articulo, la cantidad vendida y la fecha de venta.
	 */
	public void display()
	{
		System.out.println(cliente.getNombre());
		System.out.print(art.getNombre());

	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Articulo getArt() {
		return art;
	}
	public void setArt(Articulo art) {
		this.art = art;
	}
	public int getCuantos() {
		return cuantos;
	}
	public void setCuantos(int cuantos) {
		this.cuantos = cuantos;
	}
}
