package SimpleEncryption;
import java.util.ArrayList;
import java.util.Iterator;
public class SimpleEncryptionTry {

	public static void main(String[] args) {
		
		encrypt("Frase para encriptar",2);
	}

	 public static String encrypt(final String text, final int n) {
		    ArrayList<Character> textmod = new ArrayList<>();
		    String encrypted ="";
		    int c = n;
		    for(int i=0;i<text.length();i++) {
		    	textmod.add(text.charAt(i));
		    }
		    while(textmod.size()>0) {
		    	encrypted += text.charAt(c%text.length());
		    	textmod.remove(c%text.length());
		    	c +=n;
		    }
		   
		    /*
		    Iterator<Character> it = textmod.iterator();
		    while(it.hasNext()) {
		    	Character item = it.next();
		    	while(item !=null) {
		    		encrypted += item.charValue();//    get(c%text.length());
		    		c +=n;
		    		it.remove();
		    	}
		    }
	
		    */	
		    	
		    	
		    	/*for(int i = 0; i<text.length(); i++) {
		    	encrypted += text.charAt(c%text.length());
		    	c +=n;
		    	text.replaceFirst(text.charAt(c%text.length()), "");
		    	//textmod = text.replace(text.charAt(text.length()%n), '' );  
		    	 * 
		    	 
		    }*/
		    System.out.println(encrypted);
		    return encrypted;
	 }
}
