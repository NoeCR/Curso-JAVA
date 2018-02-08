package Softgset_little;
import java.util.ArrayList;
import java.util.Iterator;
public class Pruebas {

	public static void main(String[] args) {
		
	}	 
}

/*
 * private ArrayList<Articulo> articulos;
	
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
		}

String arts="";
int contador1 = 0, contador2=0;
System.out.println("Cliente: " +cliente.getNombre());
Iterator<Articulo> it = articulos.iterator();
 while(it.hasNext()) {
     Articulo articulo = it.next();
     String[] artunico = arts.split(";");
     for(int i=0; i<artunico.length;i++){
         if(articulo.getNomart().equals(artunico[i])) {
             //System.out.println("articulo encontrado");
             articulo.setCount();
             it.remove();
             contador1++;
         }else{
            //System.out.println("Nuevo articulo" + arts + " - "); 
            contador2++;
            arts += articulo.getNomart() + ";";
         }
     }
     System.out.println("Contador 1: " + contador1 + " Contador 2: " +contador2);
     System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + " cantidad: " + articulo.getCount());
}

/*arts += articulo.getNomart() + ";";
for(Articulo articulo : articulos){
    System.out.println("Articulo " + articulo.getNomart() + " Precio " + (articulo.getPrecio()*articulo.getCount()) + " cantidad: " + articulo.getCount());
}
*/        
