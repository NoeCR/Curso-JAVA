package Encriptacion;

import org.apache.commons.codec.digest.DigestUtils;

public class sha1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		String textoSinEncriptar="ContrasenyaSecreta"; 
		String textoEncriptadoConSHA=DigestUtils.sha512Hex(textoSinEncriptar);//       .sha1Hex(textoSinEncriptar); 
		System.out.println("Texto Encriptado con SHA : "+textoEncriptadoConSHA);

	}

}
