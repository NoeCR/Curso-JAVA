

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
    public Raton(String nombre,double precio,double dimensiones,double peso, String marca, String tipo, 
    int botones, String conexion, double distancia, int dpi, String sensor) {
        super(nombre, precio, dimensiones, peso, marca, tipo, botones, conexion, distancia);
        this.dpi = dpi;
        this.sensor = sensor;
           
    }
}


    

