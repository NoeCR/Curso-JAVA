package Softgset_little;

import java.util.ArrayList;
import java.util.Iterator;
public class Carro
{
    private ArrayList<Articulo> articulos;
    private Cliente cliente;    
    private double total;
    private int numfac = 0;
    public Carro(Cliente cliente){
       articulos = new ArrayList<>();
       this.cliente = cliente;
       this.numfac += 1;   
       this.total = 0;
    }
    public void addArticulo(Articulo articulo){
        articulos.add(articulo);
        setTotal(articulo.getPrecio());
        articulo.setCount();
    }
    public void displayCart(){
        String arts="";
        System.out.println("Cliente: " +cliente.getNombre());
        Iterator<Articulo> it = articulos.iterator();
         while(it.hasNext()) {
             Articulo articulo = it.next();
             String[] artunico = arts.split(";");
             for(int i=0; i<artunico.length;i++){
                 if(articulo.getNomart().equals(artunico[i])) {
                     System.out.println("articulo encontrado");
                     break;
                 }else{
                    System.out.println("Nuevo articulo--" + arts); 
                    arts += articulo.getNomart() + ";";
                 }
             }
     }

        /*
        for(Articulo articulo : articulos){
            System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + " cantidad: " + articulo.getCount());
        }
        */        
    }
    public void setTotal(double valor){
        total += valor;
    }
    public double getTotal(){
        return total;
    }
    public void realizarPedido(int cantidad, Articulo articulo){
        articulo.setUnidades(cantidad);
    }
    public void vaciarCarro(){
        Iterator<Articulo> it = articulos.iterator();
         while(it.hasNext()) {
         Articulo item = it.next();            
         it.remove();   
     }
    }
}
