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
    /**
     * Este metodo comprueba que el carro del cliente tenga algun articulo, en caso de tener algun articulo comprueba
     * que tenga fondos para pagar los articulos, si tiene fondos se genera una nueva factura, se añade al gasto total del
     * cliente el importe del pedido, se resta de la cartera el importe del pedido y se vacia el carro. Y se imprime
     * un mensage en pantalla.
     */
    public void realizarCompra(Cliente cliente){
        if(cliente.getNumarts() > 0){
            if(cliente.getCartera() < cliente.getTotal()){
                System.out.println("No tiene fondos suficientes para realizar la compra.");
            }else{              
                historico.add(new Factura(cliente, cliente.getArticulos(), cliente.getTotal()));
                cliente.setGastoTotal(cliente.getTotal());
                cliente.restarCartera(cliente.getTotal());
                cliente.vaciarCarro();
                System.out.println("Compra realizada, Gracias!");
            }
        }else{
            System.out.println("No tiene articulos en su carro.");
        }
    }
    /**
     * Este metodo imprime la factura que coincida con el numero de factura pasado como parametro
     */
    public void showFactura(int numfac){
        boolean encontrado = false;        
        Iterator<Factura> it = historico.iterator();
        while(it.hasNext()) {
         Factura item = it.next();            
            if(item.getNumfact() == numfac){
                System.out.print(item.toString());
                System.out.print("");//Linea en blanco 
                encontrado = true;                
            }
        }
        if(!encontrado){
           System.out.println("No se encontro la factura.");
        }
    }
    /**
     * Este metodo imprime todas las facturas
     */
    public void showListadoFacrutas(){
        for(Factura factura : historico){
            System.out.print(factura.toString());
            System.out.print("");
        }
    }
}
