package DNI;


/**
 * Write a description of class DNI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DNI
{
    private String numero;
    private char letra = ' ';
    /*Array privado y estático accesible para toda la clase */
    private static char[] letters = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
  
    public DNI(){
        
    }
    public DNI(String numero){
        this.numero = numero;
    }
    public DNI(String numero, char letra){
        this.numero = numero;
        this.letra = letra;
    }
    
    public boolean isDNICorrect(){
        return letters[Integer.parseInt(numero)%23] == letra;
    }
    public String getNumero(){
        return numero;
    }
    public char getLetra(){
        return letra;
    }
    public void setNumero(String nuevoNumero){
        letra = letters[Integer.parseInt(nuevoNumero)%23];
        this.numero = nuevoNumero;
    }
    public void printDni(){
        if(letra!=' '){
        System.out.println(numero + "-" + letra);
        }else{
            System.out.println(numero);
        }
    }

}
