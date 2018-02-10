import java.util.ArrayList;
import java.util.Iterator;
public class Cliente{
    
    private Tienda tienda;
    private static int id = 1;
    private int idcliente;
    private String nombre;
    private double cartera;
    private ArrayList<Articulo> articulos;
    private double total;
    private double gastocliente = 0;   
    
    public Cliente(Tienda tienda, String nombre, double cartera){
       this.idcliente = idcliente + id;       
       this.tienda = tienda; 
       this.nombre = nombre;
       this.cartera = cartera;
       articulos = new ArrayList<>();
       this.total = 0;
       id++;
    }
    public String getNombre(){
        return nombre;
    }
    public double getCartera(){
        return cartera;
    }
    public void setCartera(int valor){
        cartera += valor;
    }
    public void setId(){
        id++;
    }   
    public int getIdcliente(){
        return idcliente;
    }
    /**
     * este metodo comprueba que el articulo tenga unidades para opder ser añadido a la coleccion de articulos del cliente
     * En caso de que el valor de lass unidades sea 0 imprime que no queda stock, en caso contrario comprueba si el articulo ya esta en la
     * coleccion. Si esta en la coleccion aumenta las unidades del articulo en la coleccion y lo resta de las unidades del articulo, si no esta 
     * lo añade a la coleccion y resta una unidad al stock del articulo.
     */
    public void addArticulo(Articulo articulo){
        boolean encontrado = false;
        if(articulo.getUnidades()-1 >= 0){ 
            for(Articulo art : articulos){
                if(art.getNomart() == articulo.getNomart()){                          
                   articulo.setCount();
                   setTotal(articulo.getPrecio()); 
                   articulo.restaUnidad();
                   encontrado = true;
                }                
            }
            if(!encontrado){
                articulos.add(articulo);        
                articulo.setCount();        
                setTotal(articulo.getPrecio());
                articulo.restaUnidad();
            }  
        }else{
           System.out.println("No hay Stock del articulo");
        } 
    }
    /**
     * Este metodo es similar a addArticulo pero añadiendo el parametro cantidad para aumentar el numero de unidades
     * del articulo, este metodo comprueba que haya suficiente Stock  y en caso contrario muestra un mensaje con 
     * las unidades disponibles.
     */
    public void addArticulo(Articulo articulo, int cantidad){
        boolean encontrado = false;
        if(articulo.getUnidades()-cantidad >= 0){ 
            for(Articulo art : articulos){
                if(art.getNomart() == articulo.getNomart()){                          
                   articulo.setCount(cantidad);
                   setTotal(articulo.getPrecio() * cantidad); 
                   articulo.restarUnidades(cantidad);
                   encontrado = true;
                }                
            }
            if(!encontrado){
                articulos.add(articulo);        
                articulo.setCount(cantidad);        
                setTotal(articulo.getPrecio()*cantidad);
                articulo.restarUnidades(cantidad);
            }  
        }else{
           System.out.println("No disponemos de suficiente Stock del articulo");
           System.out.println("Quedan: " + articulo.getUnidades() + ".uds");
        } 
    }
    public ArrayList<Articulo> getArticulos(){
        ArrayList<Articulo> listadoarticulos = new ArrayList<Articulo>();
        for(Articulo articulo : articulos){
            listadoarticulos.add(articulo);
        }
        return listadoarticulos;
    }
    public void setTotal(double valor){
        total += valor;
    }
    public double getTotal(){
        return total;
    }
    public void resetTotal(){
        total = 0;
    }
    /**
     * Este metodo elimina todos los articulos del carro y resetea el valor del total a 0
     */
    public void vaciarCarro(){
        Iterator<Articulo> it = articulos.iterator();
        while(it.hasNext()) {
         Articulo item = it.next();            
         it.remove();   
         item.resetCount();           
        }
        resetTotal();
    }
    public int getNumarts(){
        return articulos.size();
    }
    public double getGastoTotal(){
        return gastocliente;
    }
    public void setGastoTotal(double valor){
        gastocliente += valor;
    }
    public int getCount(Articulo articulo){
        return articulo.getCount();
    }
    public void restarCartera(double valor){
        cartera -= valor;
    }
}
