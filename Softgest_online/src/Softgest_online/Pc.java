
public class Pc extends Articulo{
   
    private String tipo;
    
    public Pc(String nomart, double precio, int unidades, String tipo){
        super(nomart, precio, unidades);
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public String toString(){
        return "Articulo: " + getNomart() + " Precio: "+ getPrecio() + " Unidades: " + "Tipo de articulo: " + tipo;
    }
}
