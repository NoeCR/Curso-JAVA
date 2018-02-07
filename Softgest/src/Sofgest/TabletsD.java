

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
    public TabletsD(String nombre,double precio,double dimensiones,double peso, String marca, String tipo, 
    int botones, String conexion, double distancia, boolean pen, boolean multi, double area, int presion) {
        super(nombre, precio, dimensiones, peso, marca, tipo, botones, conexion, distancia);
        this.pen = pen;
        this.multi = multi;
        this.area = area;
        this.presion = presion;        
    }

    
    
}
