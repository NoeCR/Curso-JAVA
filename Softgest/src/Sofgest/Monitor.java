

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
    public Monitor(String nombre,double precio,double dimensiones,double peso, String marca, String tipo,  
    String relacion, String resolucion, String conexion,String pantalla) {
        super(nombre, precio, dimensiones, peso, marca, tipo);
        this.relacion = relacion;
        this.resolucion = resolucion;
        this.conexion = conexion;
        this.pantalla = pantalla;
    }

   
    
}
