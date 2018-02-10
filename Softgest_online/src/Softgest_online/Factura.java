import java.util.ArrayList;
import java.util.Iterator;

public class Factura{    
    private  ArrayList<Articulo> articulos;
    private Cliente cliente;
    private double totalfact;
    private int numfac = 0;
    private static int id = 1;
    //private double gastocliente = 0;
    public Factura(Cliente cliente, ArrayList<Articulo> articulos, double totalfact){        
        this.cliente = cliente;
        this.articulos = new ArrayList<Articulo>();
        this.totalfact = totalfact;
        this.numfac = numfac + id;
        id++;
    }
    
    public int getNumfact(){
        return numfac;
    }
    public String toString(){
        return "Nº Factura: " + numfac + "Nombre del cliente: " + cliente.getNombre() + "\n" + "Total factura: " + 
        totalfact;
    }
}
