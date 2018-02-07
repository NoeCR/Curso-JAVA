import java.util.Calendar;
/**
 * Escriviu aquí una descripcìó de la classe Clientes
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Clientes {

    private String nombre;
    private String apellidos;
    private String dni;
    private String mail;
    private int edad;    
       
        
    /**
     * Mètode constructor per a objectes de la classe Clientes
     */
    public Clientes(String nombre,String apellidos, String dni, String mail, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.mail = mail;
        this.edad = edad;
    }

}
 

