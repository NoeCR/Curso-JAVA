

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
    public Ordenador(String nombre,double precio,double dimensiones,double peso, String marca, String tipo,
    String procesador, String memoria, String disco,String pantalla, String grafica) {
        super(nombre, precio, dimensiones, peso, marca, tipo);
        this. procesador = procesador;
        this. memoria = memoria;
        this. disco = disco;
        this. pantalla = pantalla;
        this. grafica = grafica;        
    }
}
