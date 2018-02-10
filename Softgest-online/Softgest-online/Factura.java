import java.util.*;
import java.text.SimpleDateFormat;
public class Factura{ 
    
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private Cliente cliente;
    private double totalfact;
    private int numfac = 0;
    private static int id = 1;    
    private Date c = new Date();
    private String fecha;
    
    public Factura(Cliente cliente, ArrayList<Articulo> articulos, double totalfact){        
        this.cliente = cliente;
        this.articulos = articulos;
        this.totalfact = totalfact;
        this.numfac = numfac + id;
        this.fecha = getFecha();
        id++;
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
    public String toString(){ 
        String infoartic ="";
        if(getNumarts() >0){
            for(Articulo art : articulos){
               infoartic += art.toString();
            }
        }
        return "Nº Factura: " + numfac + "\n" + "Nombre del cliente: " + cliente.getNombre() + "\n" + 
        "Articulos: " + infoartic + "Total factura: " + totalfact + "\n" + "Fecha factura: " + fecha + "\n";
    }
    public String getFecha(){  
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy hh:mm");             
        return formater.format(c);       
    }
}
