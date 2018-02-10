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
     * este metodo añade un articulo a la coleccion. Si  se encuentra dicho articulo, en lugar de añadirlo llama al metodo setCount que
     * incrementa en una unidad ese articulo
     */
    public void addArticulo(Articulo articulo){
        boolean encontrado = false;
        for(Articulo art : articulos){
            if(art.getNomart() == articulo.getNomart()){ 
               if(art.getUnidades()-1 >= 1){
                articulo.setCount();
                setTotal(articulo.getPrecio());                
                art.restaUnidad();
               }else{
                   System.out.println("No hay Stock del articulo");
               }
               encontrado = true;
            }                
        }
        if(!encontrado){
            articulos.add(articulo);        
            articulo.setCount();        
            setTotal(articulo.getPrecio());
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
}
