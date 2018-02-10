import java.util.*;
import java.text.SimpleDateFormat;
public class Factura{ 
    
    private ArrayList<Articulo> articulos;
    private Cliente cliente;
    private double totalfact;
    private int numfac = 0;
    private static int id = 1;    
    private Date c = new Date();
    private String fecha;
    
    public Factura(Cliente cliente, ArrayList<Articulo> articulos, double totalfact){        
        this.cliente = cliente;
        this.articulos = new ArrayList<Articulo>();
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
    public ArrayList<Articulo> getArticulos(){
        return articulos;
    }
    public String toString(){
        return "Nº Factura: " + numfac + "\n" + "Nombre del cliente: " + cliente.getNombre() + "\n" + "Total factura: " + 
        totalfact + "\n" + "Fecha factura: " + fecha + "\n";
    }
    public String getFecha(){  
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy hh:mm");             
        return formater.format(c);       
    }
}
