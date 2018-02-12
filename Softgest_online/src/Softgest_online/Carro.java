import java.util.*;
public class Carro{
    
    private Cliente cliente;
    private ArrayList<Articulo> articulos; 
    private double total;
    
    public Carro(Cliente cliente){
       this.cliente = cliente;
       articulos = new ArrayList<>();
       this.total = 0;
    }
    /**
     * este metodo comprueba que el articulo tenga unidades para poder ser añadido a la coleccion de articulos del cliente
     * En caso de que el valor de las unidades sea 0 imprime que no queda stock, en caso contrario comprueba si el articulo ya esta en la
     * coleccion. Si esta en la coleccion aumenta las unidades del articulo en la coleccion y lo resta de las unidades del articulo, 
     * si no esta lo añade a la coleccion y resta una unidad al stock del articulo.
     */
    public void addArticulo(Articulo articulo){
        boolean encontrado = false;
        if(articulo.getCantidad()-1 >= 0){ 
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
        if(articulo.getCantidad()-cantidad >= 0){ 
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
           System.out.println("Quedan: " + articulo.getCantidad() + ".uds");
        } 
    }
    /**
     * Metodo que devuelve un listado con todos los articulos del carro del cliente
     */
    public ArrayList<Articulo> getArticulos(){       
        return articulos;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setTotal(double valor){
        total += valor;
    }
    public void restaTotal(double valor){
        total -= valor;
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
    /**
     * Metodo para eliminar un articulo del carro del cliente, y descontar del total del carro del cliente el precio del
     * articulo por las unidades que tuviera
     */
    public void eliminarArticulo(Articulo articulo){
        Iterator<Articulo> it = articulos.iterator();
        while(it.hasNext()) {
            Articulo item = it.next();
            if(item.getId() == articulo.getId()){
                restaTotal(articulo.getPrecio() * articulo.getCount());
                articulo.setUnidades(articulo.getCount());
                articulo.resetCount();
                it.remove();
            }
        }
    }
    /**
     * Metodo que resta una unidad del contador de un articulo del carro del cliente o lo elimina si su cantidad es 0
     */
    public void restarArticulo(Articulo articulo){
        if(articulo.getCount()-1 <= 0){            
            eliminarArticulo(articulo);
        }else{
            restaTotal(articulo.getPrecio());
            articulo.setUnidades(1);
            articulo.restarCount();            
        }
    }
    /**
     * Metodo que resta una cantidad del contador de un articulo del carro del cliente o lo elimina si llega a 0
     */
    public void restarArticulo(Articulo articulo, int cantidad){
        if(articulo.getCount()-cantidad <= 0){            
            eliminarArticulo(articulo);
        }else{
            restaTotal(articulo.getPrecio() * cantidad);
            articulo.setUnidades(cantidad);
            articulo.restarCount(cantidad);
        }
    }
    public int getNumarts(){
        return articulos.size();
    }
    public String toString(){
        String infocarro;
        infocarro = "ID: " + cliente.getIdcliente() + "\n" + "Nombre: " + cliente.getNombre() + "\n";
        if(getNumarts() >0){
            for(Articulo art : articulos){
               infocarro += "Articulo: " + art.getNomart() + " Precio " + art.getPrecio() + "\n";
            }
        }
        infocarro += "Total: " + total;
        return  infocarro;                 
    }
}
