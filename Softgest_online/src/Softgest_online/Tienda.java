import java.util.ArrayList;
import java.util.Iterator;

public class Tienda{    
    
    private ArrayList<Factura> historico;
    
    public Tienda(){        
        historico = new ArrayList<Factura>();
    }

    public void realizarPedido(int cantidad, Pc articulo){
        articulo.setUnidades(cantidad);
    }
    public void aumentarCartera(double valor, Cliente cliente){
        cliente.setCartera(valor);
    }
    public int getNumarts(Carro carro){
        return carro.getNumarts();
    }
    public void displayCart(Carro carro){        
        System.out.println("Cliente: " +carro.getCliente().getNombre());
        Iterator<Articulo> it = carro.getArticulos().iterator();
        while(it.hasNext()) {
             Articulo articulo = it.next();                     
             if(articulo.getCount() > 0) {
                 System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + 
                 " cantidad: " + articulo.getCount());
             }
        }
        System.out.println("Total: " + carro.getTotal());             
    }
    /**
     * Este metodo comprueba que el carro del cliente tenga algun articulo, en caso de tener algun articulo comprueba
     * que tenga fondos para pagar los articulos, si tiene fondos se genera una nueva factura, se añade al gasto total del
     * cliente el importe del pedido, se resta de la cartera el importe del pedido y se vacia el carro. Y se imprime
     * un mensage en pantalla.
     */
    public void realizarCompra(Carro carro){
        if(carro.getNumarts() > 0){
            if(carro.getCliente().getCartera() < carro.getTotal()){
                System.out.println("No tiene fondos suficientes para realizar la compra.");
            }else{ 
                Factura f = new Factura(carro);
                historico.add(f);
                carro.getCliente().setGastoTotal(f.getTotal());
                carro.getCliente().restarCartera(f.getTotal());          
                carro.vaciarCarro();
                System.out.println(f.toString());
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
        int i = 0;
        if(buscada != null){
            historico.add(new Factura(buscada));
            Iterator<Factura> it = historico.iterator();
            while(it.hasNext()) {
             Factura item = it.next();            
                if(item.getNumfact() == historico.get(historico.size()-1).getNumfact()){
                    System.out.println("esta debe ser la ultima factura creada desde este metodo");
                    item.getCarro().getCliente().setCartera(item.getTotal());//Se devuelve el importe de la devolucion a la cartera del cliente
                    item.getCarro().getCliente().restaGastoTotal(item.getTotal());//Resta del gasto total del cliente el importe de la factura
                    for(Articulo articulo : item.getArticulos()){
                        articulo.setUnidades(item.getUnidades().get(i));//suma la cantidad de articulos a las unidades disponibles del articulo
                        i++;
                    }
                }
            }
        }else{
            System.out.print("No se encontro la factura.");
        }     
    }
     public void printFactura(Cliente cliente){
        boolean encontrado = false; 
        ArrayList<Factura> facturascliente = new ArrayList<Factura>();
        Iterator<Factura> it = historico.iterator();
        while(it.hasNext()) {
         Factura item = it.next();            
            if(item.getCarro().getCliente().getIdcliente() == cliente.getIdcliente()){
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
