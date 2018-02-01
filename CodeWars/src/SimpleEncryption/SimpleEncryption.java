package SimpleEncryption;

public class SimpleEncryption {

	  public static String encrypt(final String text, final int n) {
		    char [] textmod;
		    String encrypted ="";
		    for(int i = 0; i<text.length(); i++) {
		    	encrypted += text.charAt(text.length()%n);
		    	//textmod = text.replace(text.charAt(text.length()%n), '' );  
		    }
		  
		  
		    return null;   
		  }
		  
		  public static String decrypt(final String encryptedText, final int n) {
		    // Your code here
		    return null;
		  }
	
}
