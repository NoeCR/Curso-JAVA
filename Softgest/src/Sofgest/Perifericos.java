

/**
 * Escriviu aquí una descripcìó de la classe Perifericos
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Perifericos extends Articulo{

    private int botones;
    private String conexion;
    private double distancia;
    
    /**
     * Mètode constructor per a objectes de la classe Perifericos
     */
    public Perifericos(String nombre,double precio,double dimensiones,double peso, String marca, String tipo, 
    int botones, String conexion, double distancia) {
        super(nombre, precio, dimensiones, peso, marca, tipo);
        this.botones = botones;
        this.conexion = conexion;
        this.distancia = distancia;
    }


    
}
