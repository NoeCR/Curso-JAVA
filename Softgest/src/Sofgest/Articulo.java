package Sofgest;

 

 



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
    private String dimensiones;
    private double peso;
    private String marca;
    private String tipo;
    private int cantidad;
    

    /**
     * Mètode constructor per a objectes de la classe Articulos
     */
    public Articulo(String nombre,double precio,String dimensiones,double peso, String marca, String tipo) {
      this.nombre = nombre;  
      this.precio = precio;  
      this.dimensiones = dimensiones;  
      this.peso = peso;  
      this.marca = marca;  
      this.tipo = tipo;  
      this.cantidad = 0;  
        
    }
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
    public int getCantidad(){
        return cantidad;
    }
    
}
