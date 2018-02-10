package Pruebas;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Fechas {

	public static void main(String[] args) {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String strDate= formatter.format(date);
		System.out.println(strDate);
	}

}
