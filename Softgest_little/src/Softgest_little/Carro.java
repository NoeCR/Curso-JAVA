import java.util.ArrayList;
import java.util.Iterator;
public class Carro
{
    private ArrayList<Articulo> articulos;
    private Cliente cliente;    
    private double total; 
    private Historico factura;
    /**
     * Constructor de la clase carro, un carro establece una relacion entre un unico cliente y un o una coleccion de articulos
     * Un carro tendra como campos una coleccion de articulos, un unico cliente y un total que sera el acumulado de todos los articulos
     */
    public Carro(Cliente cliente){
       articulos = new ArrayList<>();
       this.cliente = cliente;         
       this.total = 0;
    }
    /**
     * este metodo añade un articulo a la coleccion. Si  se encuentra dicho articulo, en lugar de añadirlo llama al metodo setCount que
     * incrementa en una unidad ese articulo
     */
    public void addArticulo(Articulo articulo){
        boolean encontrado = false;
        for(Articulo art : articulos){
            if(art.getNomart() == articulo.getNomart()){
                articulo.setCount();
                setTotal(articulo.getPrecio());
                encontrado = true;
            }                
        }
        if(!encontrado){
            articulos.add(articulo);        
            articulo.setCount();        
            setTotal(articulo.getPrecio());
        }   
    }
    /**
     * Este metodo imprime el cliente con el que se a creado el carro y la coleccion de articulos si los hay, y por ultimo el total del pedido 
     */
    public void displayCart(){        
        System.out.println("Cliente: " +cliente.getNombre());
        Iterator<Articulo> it = articulos.iterator();
        while(it.hasNext()) {
             Articulo articulo = it.next();                     
             if(articulo.getCount() > 0) {
                 System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + " cantidad: " + articulo.getCount());
             }
        }
        System.out.println("Total: " + getTotal());             
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
    public void realizarPedido(int cantidad, Articulo articulo){
        articulo.setUnidades(cantidad);
    }
    public void aumentarCartera(int valor){
        cliente.setCartera(valor);
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
    public void facturar(){
        if(cliente.getCartera() < getTotal()){
            System.out.println("no tiene fondos para realizar la compra");
        }else{
            System.out.println("Compra realizada, gracias!");
            factura = new Historico(cliente, articulos, getTotal());
            vaciarCarro();
        }
    }
    public void showfactura(){
        ArrayList<Articulo> facart = factura.getArticulos();
        System.out.print(factura.getCliente().getNombre());
        System.out.print("");
        for (Articulo articulo : facart){
            System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + " cantidad: " + articulo.getCount());
        }
        System.out.println(factura.getGastocliente());
    }
}
