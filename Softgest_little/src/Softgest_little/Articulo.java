

public class Articulo
{
    private String nomart;
    private double precio; 
    private int unidades;
    private int count = 0;
    public Articulo(String nomart, double precio){
       this.nomart = nomart;
       this.precio = precio;
       this.unidades = 0;
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
        System.out.print(getNomart() + ","+ getPrecio());
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
    public void resetCount(){
        count = 0;
    }
}
