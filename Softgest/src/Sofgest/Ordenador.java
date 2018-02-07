package Sofgest;

/**
 * Escriviu aquí una descripcìó de la classe Ordenador
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Ordenador extends Articulo{

	private String procesador;
	private String memoria;
	private String disco;
	private String pantalla;
	private String grafica;

	/**
	 * Mètode constructor per a objectes de la classe Ordenador
	 */
	public Ordenador(String nombre,double precio,String dimensiones,double peso, String marca, String tipo,
			String procesador, String memoria, String disco,String pantalla, String grafica) {
		super(nombre, precio, dimensiones, peso, marca, tipo);
		this. procesador = procesador;
		this. memoria = memoria;
		this. disco = disco;
		this. pantalla = pantalla;
		this. grafica = grafica;        
	}
	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getDisco() {
		return disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}

	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}

	public String getGrafica() {
		return grafica;
	}

	public void setGrafica(String grafica) {
		this.grafica = grafica;
	}
}
