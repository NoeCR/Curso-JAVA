import java.util.ArrayList;
import java.util.Iterator;
public class Cliente{
    
    private Tienda tienda;
    private static int id = 1;
    private int idcliente;
    private String nombre;
    private double cartera;   
    private double gastocliente = 0;   
    
    public Cliente(Tienda tienda, String nombre, double cartera){
       this.idcliente = idcliente + id;       
       this.tienda = tienda; 
       this.nombre = nombre;
       this.cartera = cartera;      
       id++;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nuevonombre){
        this.nombre = nuevonombre;
    }
    public double getCartera(){
        return cartera;
    }
    public void setCartera(double valor){
        cartera += valor;
    }
    public void setId(){
        id++;
    }   
    public int getIdcliente(){
        return idcliente;
    }    
    public double getGastoTotal(){
        return gastocliente;
    }
    public void setGastoTotal(double valor){
        gastocliente += valor;
    }
    public void restaGastoTotal(double valor){
        gastocliente -= valor;
    }
    public int getCount(Articulo articulo){
        return articulo.getCount();
    }
    public void restarCartera(double valor){
        cartera -= valor;
    }
     public String toString(){
        return  "ID: " + getIdcliente() + "\n" + "Nombre: " + getNombre() + "\n" + "Cartera: " + cartera;                 
    }
}
