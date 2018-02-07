package Sofgest;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import java.io.IOException;
import java.util.ArrayList;

public class Pruebas {

	public static void main(String[] args) throws IOException{
		
			List sheetData = Import.getClientes();
			//
			// Iterates the data and print it out to the console.
			//
			for (int i = 1; i < sheetData.size(); i++) {
				List list = (List) sheetData.get(i);
				for (int j = 0; j < list.size(); j++) {
					Cell cell = (Cell) list.get(j);
					if(j == 0) {
						System.out.println("Nombre: " + cell.getRichStringCellValue());
					}else if(j ==1) {
						System.out.println("Apellidos: " + cell.getRichStringCellValue());
					}else if(j ==2) {
						System.out.println("Email: " + cell.getRichStringCellValue());
					}else if(j ==3) {
						System.out.println("Edad: " + cell.getNumericCellValue());
					}else if(j ==4) {
						System.out.println("DNI: " + cell.getRichStringCellValue());
					}else if(j ==5) {
						System.out.println("Telefono: " + cell.getNumericCellValue());
					}									
				}
				System.out.println("");
			}
		}		
}