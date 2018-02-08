

public class Cliente
{
    private String nombre;
    private double cartera;
    /**
     * Constructor for objects of class Cliente
     */
    public Cliente(String nombre, double cartera){
       this.nombre = nombre;
       this.cartera = cartera;
    }

    public String getNombre(){
        return nombre;
    }
    public double getCartera(){
        return cartera;
    }
    public void setCartera(int valor){
        cartera += valor;
    }
}
