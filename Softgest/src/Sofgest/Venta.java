import java.util.ArrayList;

/**
 * Escriviu aquí una descripcìó de la classe Venta
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Venta {
    private long timestamp;
    private Clientes cliente;
    private Articulo art;
    private int cuantos;
    /**
     * Mètode constructor per a objectes de la classe Venta
     */
    public Venta(Clientes cliente, Articulo articulo, int cuantos) {
        this.cliente = cliente;
        this.art = articulo;
        this.cuantos = art.getCantidad();
        timestamp = System.currentTimeMillis();
    }
    /**
     * Metodo para mostrar el nombre y apellidos del cliente, el nombre y precio del articulo, la cantidad vendida y la fecha de venta.
     */
    public void display()
    {
        //System.out.println(cliente);
        //System.out.print(art);
        
    }
}
