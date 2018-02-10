import java.util.ArrayList;
import java.util.Iterator;

public class Tienda{
   
    private ArrayList<Articulo> articulos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> historico;
    
    public Tienda(){
        articulos = new ArrayList<Articulo>();
        clientes = new ArrayList<Cliente>();
        historico = new ArrayList<Factura>();
    }

    public void realizarPedido(int cantidad, Articulo articulo){
        articulo.setUnidades(cantidad);
    }
    public void aumentarCartera(int valor, Cliente cliente){
        cliente.setCartera(valor);
    }
    public int getNumarts(Cliente cliente){
        return cliente.getNumarts();
    }
    public void displayCart(Cliente cliente){        
        System.out.println("Cliente: " +cliente.getNombre());
        Iterator<Articulo> it = cliente.getArticulos().iterator();
        while(it.hasNext()) {
             Articulo articulo = it.next();                     
             if(articulo.getCount() > 0) {
                 System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + " cantidad: " + articulo.getCount());
             }
        }
        System.out.println("Total: " + cliente.getTotal());             
    }
    public void realizarCompra(Cliente cliente){
        if(cliente.getNumarts() > 0){
            if(cliente.getCartera() < cliente.getTotal()){
                System.out.println("No tiene fondos suficientes para realizar la compra.");
            }else{
                //facturaprueba = new Factura(cliente, cliente.getArticulos(), cliente.getTotal());
                historico.add(new Factura(cliente, cliente.getArticulos(), cliente.getTotal()));
                cliente.vaciarCarro();
                System.out.println("Compra realizada, Gracias!");
            }
        }else{
            System.out.println("No tiene articulos en su carro.");
        }
    }
    public void showFactura(int numfac){
        boolean encontrado = false;
        Factura factura = null;
        Iterator<Factura> it = historico.iterator();
        while(it.hasNext()) {
         Factura item = it.next();            
            if(item.getNumfact() == numfac){
                encontrado = true;
                factura = item;
            }
        }
        if(encontrado){
            factura.toString();
        }else{
            System.out.println("No se encontro la factura.");
        }
    } 
}
