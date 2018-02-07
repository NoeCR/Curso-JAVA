package Sofgest;
/**
 * Escriviu aquí una descripcìó de la classe Monitor
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Monitor extends Articulo{

	private String relacion; 
	private String resolucion;
	private String conexion;
	private String pantalla;

	/**
	 * Mètode constructor per a objectes de la classe Monitor
	 */
	public Monitor(String nombre,double precio,String dimensiones,double peso, String marca, String tipo,  
			String relacion, String resolucion, String conexion,String pantalla) {
		super(nombre, precio, dimensiones, peso, marca, tipo);
		this.relacion = relacion;
		this.resolucion = resolucion;
		this.conexion = conexion;
		this.pantalla = pantalla;
	}
	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}

	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}



}
