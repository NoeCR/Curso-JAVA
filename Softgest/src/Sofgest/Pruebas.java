package Sofgest;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pruebas {

	public static void main(String[] args) throws IOException{
		RichTextString nombre = null;
		RichTextString apellidos = null;
		RichTextString mail = null;
		double edad = 0;
		RichTextString dni = null;
		double telefono = 0;
			List sheetData = Import.getClientes();
			Array[] cln = new Array[sheetData.size()];  
			Clientes arrayObjetos[]=new Clientes[sheetData.size()-1];
			for (int i = 1; i < sheetData.size(); i++) {
				List list = (List) sheetData.get(i);
				for (int j = 0; j < list.size(); j++) {
					Cell cell = (Cell) list.get(j);
					if(j == 0) {
						nombre = cell.getRichStringCellValue();
						//System.out.println("Nombre: " + cell.getRichStringCellValue());
					}else if(j ==1) {
						apellidos = cell.getRichStringCellValue();
						//System.out.println("Apellidos: " + cell.getRichStringCellValue());
					}else if(j ==2) {
						mail = cell.getRichStringCellValue();
						//System.out.println("Email: " + cell.getRichStringCellValue());
					}else if(j ==3) {
						edad = cell.getNumericCellValue();
						//System.out.println("Edad: " + cell.getNumericCellValue());
					}else if(j ==4) {
						dni = cell.getRichStringCellValue();
						//System.out.println("DNI: " + cell.getRichStringCellValue());
					}else if(j ==5) {
						telefono = cell.getNumericCellValue();
						//System.out.println("Telefono: " + cell.getNumericCellValue());
					}	
					
							//nombre, apellidos , mail , edad , dni , telefono;
				}
				System.out.println("Nombre " + nombre +", Apellidos " +  apellidos +", Mail " +mail
						+", Edad " +edad +", DNI " + dni+", Telefono "+ telefono);
				arrayObjetos[i-1]= new Clientes(nombre, apellidos , mail , edad , dni , telefono);
				//System.out.println("");
			}

		}		
}