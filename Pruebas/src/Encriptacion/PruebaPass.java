package Encriptacion;

public class PruebaPass {
    public static void main(String[] args) throws Exception {				
    
    	AESCrypt pass = new AESCrypt();
    	
    	String encriptada = pass.encrypt("micontraseña").toString();
    	System.out.println(encriptada);
    /*	
    HashSalt hs = PasswordUtil.getHash("miPassword");
	System.out.println(hs.getHash()); // bWlQYXNzd29yZA==
	System.out.println(hs.getSalt()); // SMB6x5uRy4kIPYN512ibug==
	
	boolean isValid = PasswordUtil.ValidatePass("miPassword2", hs.getHash(), hs.getSalt());
	System.out.println(isValid ? "válida" : "no válida"); // no válida
	*/
    }
}
