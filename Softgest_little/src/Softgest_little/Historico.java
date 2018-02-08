import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class Historico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Historico
{
    private int numfac = 1;
    private  ArrayList<Articulo> articulos;
    private  ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private double totalfactura = 0;
    private double gastocliente = 0;

    public Historico(Cliente cliente, ArrayList<Articulo> artics, double totalfactura){
        this.clientes.add(cliente);
        this.articulos = artics;
        this.totalfactura = totalfactura;
        numfac++;
    }
    public double acumCliente(Cliente cliente, double gastocliente){
        return gastocliente += gastocliente;
    }
    public  void addCliente(Cliente cli){
        clientes.add(cli);
    }
    public  Cliente getCliente(){
        for(Cliente cliente : clientes){
            return cliente;
        }
        return null;
    }
    public ArrayList<Articulo> getArticulos(){
        ArrayList<Articulo> artcliente = new ArrayList<Articulo>();
        for(Articulo articulo : articulos){
            artcliente.add(articulo);
        }
        return artcliente;
    }
    public double getGastocliente(){
        return gastocliente;
    }
    /**
     * Crear metodo que al ser llamado desde el constructor instancie un objeto de la clase Gregoriancalendar o Calendar
     * extraiga (año,mes y dia) y lo devuleva como un String
     */
}
