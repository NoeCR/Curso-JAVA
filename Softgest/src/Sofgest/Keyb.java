

/**
 * Escriviu aquí una descripcìó de la classe Keyb
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Keyb extends Perifericos{

    private boolean retroilu;
    private boolean numeric;
    private String tecno;
    private int frec;
    
    /**
     * Mètode constructor per a objectes de la classe Keyb
     */
    public Keyb(String nombre,double precio,double dimensiones,double peso, String marca, String tipo, 
    int botones, String conexion, double distancia, boolean retro, boolean numeric, String tecno, int frec) {
        super(nombre, precio, dimensiones, peso, marca, tipo, botones, conexion, distancia);
        this.retroilu = retroilu;
        this.numeric = numeric;
        this.tecno = tecno;
        this.frec = frec;        
    }
}



