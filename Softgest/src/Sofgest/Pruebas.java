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

	
	/*
	 * if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						System.out.print(cell.getNumericCellValue());
					} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.print(cell.getRichStringCellValue());
					} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
						System.out.print(cell.getBooleanCellValue());
					}
					if (j < list.size() - 1) {
						System.out.print(", ");
					}
	 * 
	 * 
	
	//System.out.println(Import.getClientes());
			ArrayList<List> clientes = new ArrayList<>();
			clientes.add(Import.getClientes());
			System.out.println(clientes);
			Iterator<List> it = clientes.iterator();
			 while(it.hasNext()) {
				 List item = it.next();
				 if(item != null) {
					 System.out.println(item);
				 }
			 }
			 for(List cliente : clientes) {
				 System.out.println(cliente);
			 }
			
		}
	
	*/ 