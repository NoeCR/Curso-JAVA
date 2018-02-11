import java.util.*;
import java.text.SimpleDateFormat;
public class Factura{ 
    
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private ArrayList<Integer> unidades = new ArrayList<Integer>();// En este arrya se deberian almacenar las unidades de cada articulo de la coleccion 
    private Cliente cliente;
    private double totalfact;
    private int numfac = 0;
    private static int id = 1;    
    private Date c = new Date();
    private String fecha;
    private String concepto =" ";
    
    public Factura(Cliente cliente, ArrayList<Articulo> articulos, double totalfact){        
        this.cliente = cliente;
        this.articulos = articulos;
        for(Articulo articulo : articulos){
            this.unidades.add(articulo.getCount());
        }
        this.totalfact = totalfact;
        this.numfac = numfac + id;
        this.fecha = getFecha();
        id++;
    }
    /**
     * Metodo constructor para realiazr devoluciones de facturas a clientes, 
     */
    public Factura (Factura factura){
        this.concepto = "Devolucion factura Nº: " + factura.getNumfact();
        this.cliente = factura.getCliente() ;
        this.articulos = factura.getArticulos();
        this.totalfact = factura.getTotal();
        this.numfac = numfac + id;
        this.fecha = getFecha();
        id++;
    }
     /**
     * Metodo que devuelve un listado con todos los articulos facturados
     */
    public ArrayList<Articulo> getArticulos(){
        ArrayList<Articulo> listadoarticulos = new ArrayList<Articulo>();
        for(Articulo articulo : articulos){
            listadoarticulos.add(articulo);
        }
        return listadoarticulos;
    }
    public int getNumfact(){
        return numfac;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public int getNumarts(){
        return articulos.size();
    }
    public double getTotal(){
        return totalfact;
    }
    public String toString(){ 
        String infoartic ="";
        int i = 0;
        if(getNumarts() >0){
            for(Articulo art : articulos){
               infoartic += art.toString() + unidades.get(i) + "\n";
               i++;
            }
        }
        return "Nº Factura: " + numfac + "\n" + "Nombre del cliente: " + cliente.getNombre() + "\n" + 
        "Articulos: " + infoartic + "Total factura: " + totalfact + "\n" + "Fecha factura: " + fecha + "\n" + concepto + "\n";
    }
    public String getFecha(){  
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy hh:mm");             
        return formater.format(c);       
    }
}
