package Sofgest;
/**
 * Escriviu aquí una descripcìó de la classe TabletsD
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class TabletsD extends Perifericos{

	private boolean pen;
	private boolean multi;
	private double area;
	private int presion;
	/**
	 * Mètode constructor per a objectes de la classe TabletsD
	 */
	public TabletsD(String nombre,double precio,String dimensiones,double peso, String marca, String tipo, 
			int botones, String conexion, double distancia, boolean pen, boolean multi, double area, int presion) {
		super(nombre, precio, dimensiones, peso, marca, tipo, botones, conexion, distancia);
		this.pen = pen;
		this.multi = multi;
		this.area = area;
		this.presion = presion;        
	}

	public boolean isPen() {
		return pen;
	}
	public void setPen(boolean pen) {
		this.pen = pen;
	}
	public boolean isMulti() {
		return multi;
	}
	public void setMulti(boolean multi) {
		this.multi = multi;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getPresion() {
		return presion;
	}
	public void setPresion(int presion) {
		this.presion = presion;
	}

}
