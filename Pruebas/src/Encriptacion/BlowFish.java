package Encriptacion;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class BlowFish {

	public static void main(String[] args) throws Exception {
			String pass = encrypt("edwin","password");
			System.out.println(pass);
			System.out.println(decrypt("edwin",pass));
	}
	private static String encrypt(String username, String password) throws Exception {
		String strkey= username;
		   SecretKeySpec key = new SecretKeySpec(strkey.getBytes("UTF-8"), "Blowfish");
		        Cipher cipher = Cipher.getInstance("Blowfish");
		        if ( cipher == null || key == null) {
		            throw new Exception("Invalid key or cypher");
		        }
		        cipher.init(Cipher.ENCRYPT_MODE, key);
		String encryptedData =new String(cipher.doFinal(password.getBytes("UTF-8")));
		return encryptedData;
    }
     
    private static String decrypt(String username, String string) throws Exception {
    	String strkey= username;
    	SecretKeySpec key = new SecretKeySpec(strkey.getBytes("UTF-8"), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(string.getBytes());
        return new String(decrypted);
    }
}
