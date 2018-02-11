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
    public void aumentarCartera(double valor, Cliente cliente){
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
                 System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + 
                 " cantidad: " + articulo.getCount());
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
                System.out.println("Compra realizada, Gracias!" +"\n");                
            }
        }else{
            System.out.println("No tiene articulos en su carro." +"\n");
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
            System.out.print("");//Linea en blanco 
        }
    }
    public void displayCliente(Cliente cliente){
        System.out.println(cliente.toString());
    }
    public Factura findFactura(int numfac){
        Factura factura = null;
        Iterator<Factura> it = historico.iterator();
        while(it.hasNext()) {
         Factura item = it.next();            
            if(item.getNumfact() == numfac){
                factura = item;
            }
        }
        return factura;
    }
    public void printFactura(int numfac){
        Factura buscada = findFactura(numfac);            
            if(buscada != null){
                System.out.print(buscada.toString());
                System.out.print("");//Linea en blanco   
            }else{
                System.out.print("No se encontro la factura.");
            }        
    }
    /**
     * Este metodo debe crear una nueva factura, obtener el ultimo elemento de la colección del historico y a traves de los datos de este elemento
     * realizar la devolucion del importe al cliente, añadir la cantidad de cada articulo devuelto ( que seran todos los que se reflejen en la factura)
     * restar del total de gasto del cliente el importe de la factura
     */
    public void devolucionFactura(int numfac){
        Factura buscada = findFactura(numfac);
        //System.out.println(buscada.toString());
        historico.add(new Factura(buscada));
        Iterator<Factura> it = historico.iterator();
        while(it.hasNext()) {
         Factura item = it.next();            
            if(item.getNumfact() == historico.get(historico.size()-1).getNumfact()){
                System.out.println("esta debe ser la ultima factura creada pasada desde este metodo");
                item.getCliente().setCartera(item.getTotal());//Se devuelve el importe de la devolucion a la cartera del cliente
                item.getCliente().restaGastoTotal(item.getTotal());//Resta del gasto total del cliente el importe de la factura
            }
        }
    }
     public void printFactura(Cliente cliente){
        boolean encontrado = false; 
        ArrayList<Factura> facturascliente = new ArrayList<Factura>();
        Iterator<Factura> it = historico.iterator();
        while(it.hasNext()) {
         Factura item = it.next();            
            if(item.getCliente().getIdcliente() == cliente.getIdcliente()){
                encontrado = true;
                facturascliente.add(item);                
            }
        }
        if(encontrado){
            for(Factura factura : facturascliente){
                System.out.println(factura.toString());
                System.out.print("");//Linea en blanco   
            }
        }else{
            System.out.print("No hay ninguna factura de este cliente.");
        }        
    } 
}
