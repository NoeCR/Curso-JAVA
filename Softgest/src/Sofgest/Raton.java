package Sofgest;
/**
 * Escriviu aquí una descripcìó de la classe Raton
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Raton extends Perifericos{


	private int dpi;
	private String sensor;
	/**
	 * Mètode constructor per a objectes de la classe Raton
	 */
	public Raton(String nombre,double precio,String dimensiones,double peso, String marca, String tipo, 
			int botones, String conexion, double distancia, int dpi, String sensor) {
		super(nombre, precio, dimensiones, peso, marca, tipo, botones, conexion, distancia);
		this.dpi = dpi;
		this.sensor = sensor;

	}
	public int getDpi() {
		return dpi;
	}
	public void setDpi(int dpi) {
		this.dpi = dpi;
	}
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
}


    

