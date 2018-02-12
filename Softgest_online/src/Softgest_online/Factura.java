import java.util.*;
import java.text.SimpleDateFormat;
public class Factura{ 
    
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private ArrayList<Integer> unidades = new ArrayList<Integer>();// En este arrya se deberian almacenar las unidades de cada articulo de la coleccion 
    private Carro carro;
    private double totalfact;
    private int numfac = 0;
    private static int id = 1;    
    private Date c = new Date();
    private String fecha;
    private String concepto =" ";
    
    public Factura(Carro carro){        
        this.carro = carro;
        this.articulos.addAll(carro.getArticulos()); 
        for(Articulo articulo : carro.getArticulos()){
            this.unidades.add(articulo.getCount());
        }
        this.totalfact = carro.getTotal();
        this.numfac = numfac + id;
        this.fecha = getFecha();
        id++;
    }
    /**
     * Metodo constructor para realiazr devoluciones de facturas a clientes, 
     */
    public Factura (Factura factura){
        int i = 0;
        this.concepto = "Devolucion factura Nº: " + factura.getNumfact();
        this.carro = factura.getCarro();
        this.articulos = factura.getArticulos();
        for(Articulo articulo : articulos){
            this.unidades.add(factura.getUnidades().get(i));
            i++;
        }
        this.totalfact = factura.getTotal();
        this.numfac = numfac + id;
        this.fecha = getFecha();
        id++;
    }
     /**
     * Metodo que devuelve un listado con todos los articulos facturados
     */
    public ArrayList<Articulo> getArticulos(){       
        return articulos;
    }
    public Carro getCarro(){
        return carro;
    }
    public ArrayList<Integer> getUnidades(){
        ArrayList<Integer> udarticulos = new ArrayList<Integer>();
        for(Integer unidad : unidades){
            udarticulos.add(unidad);
        }
        return udarticulos;
    }
    public int getNumfact(){
        return numfac;
    }
    public int getNumarts(){
        System.out.println(this.articulos.size());
        return this.articulos.size();
    }
    public double getTotal(){
        return totalfact;
    }
    public String toString(){ 
        String infoartic ="";
        int i = 0;
        if(getNumarts() >0){
            for(Articulo art : articulos){
               infoartic += art.toString() + getUnidades().get(i) + "\n";
               i++;
            }
        }
        return "Nº Factura: " + numfac + "\n" + "Nombre del cliente: " + carro.getCliente().getNombre() + "\n" + 
        "Articulos: " + infoartic + "Total factura: " + totalfact + "\n" + "Fecha factura: " + fecha + "\n" + concepto + "\n";
    }
    public String getFecha(){  
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy hh:mm");             
        return formater.format(c);       
    }
    public int findMes(String fecha){
        String[] separador = fecha.split("/");
        return Integer.parseInt(separador[1]);
    }
    public String findYear(String fecha){
        String[] separador = fecha.split("/");        
        return separador[2].substring(0, 3);
    }
}
