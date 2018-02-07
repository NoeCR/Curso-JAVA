

/**
 * Escriviu aquí una descripcìó de la classe Articulos
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Articulo {

    // Variables d'instància. Canvieu l'exemple d'aquí sota pels vostres exemples
    private String nombre;
    private double precio;
    private double dimensiones;
    private double peso;
    private String marca;
    private String tipo;
    private int cantidad;
    

    /**
     * Mètode constructor per a objectes de la classe Articulos
     */
    public Articulo(String nombre,double precio,double dimensiones,double peso, String marca, String tipo) {
      this.nombre = nombre;  
      this.precio = precio;  
      this.dimensiones = dimensiones;  
      this.peso = peso;  
      this.marca = marca;  
      this.tipo = tipo;  
      this.cantidad = 0;  
        
    }

    public int getCantidad(){
        return cantidad;
    }
    
}
