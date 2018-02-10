
public class Articulo{

    private String nomart;
    private double precio; 
    private int unidades;
    private int count = 0;
    private static int id = 1;
    private int idart;
    public Articulo(String nomart, double precio){
       this.nomart = nomart;
       this.precio = precio;
       this.unidades = 0;
    }
    public Articulo(String nomart, double precio, int unidades){
       this.nomart = nomart;
       this.precio = precio;
       this.unidades = unidades;
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
        System.out.print("Articulo: " + getNomart() + " Precio: "+ getPrecio() + " Unidades: " + getUnidades());
        System.out.print("");
    }
    public String toString(){
        return "Articulo: " + getNomart() + " Precio: "+ getPrecio() + " Unidades: " +  getCount() + "\n";
    }
    public void setUnidades(int valor){
        unidades += valor;
    }
    public int getUnidades(){
        return unidades;
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
        unidades = 0;
    }
    public void restaUnidad(){
        unidades--;
    }
    public void restarUnidades(int cantidad){
        unidades -= cantidad;
    }
    public int getId(){
        return idart;
    }
}
