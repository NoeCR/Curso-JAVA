
public class Articulo{

    private String nomart;
    private double precio; 
    private int cantidad;
    private int count = 0;
    private static int id = 1;
    private int idart;
    public Articulo(String nomart, double precio){
       this.nomart = nomart;
       this.precio = precio;
       this.cantidad = 0;
    }
    public Articulo(String nomart, double precio, int unidades){
       this.nomart = nomart;
       this.precio = precio;
       this.cantidad = unidades;
       this.idart= idart + id;
       id++;
    }
    public String getNomart(){
        return nomart;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public void display(){
        System.out.print("Articulo: " + getNomart() + " Precio: "+ getPrecio() + " Unidades: " + getCantidad());
        System.out.println("");
    }
    public String toString(){
        return "Articulo: " + getNomart() + " Precio: "+ getPrecio() + " Unidades: ";
    }
    public void setUnidades(int valor){
        cantidad += valor;
    }
    public int getCantidad(){
        return cantidad;
    }
    public int getCount(){
        return count;
    }
    public void setCount(){
        count++;
    }
    public void setCount(int cantidad){
        count += cantidad;
    }
    public void resetCount(){
        count = 0;
    }
    public void restarCount(){
        count--;
    }
    public void restarCount(int cantidad){
        count -= cantidad;
    }
    public void resetArt(){
        cantidad = 0;
    }
    public void restaUnidad(){
        cantidad--;
    }
    public void restarUnidades(int valor){
        cantidad -= valor;
    }
    public int getId(){
        return idart;
    }
}
