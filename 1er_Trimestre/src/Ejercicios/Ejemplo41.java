package Ejercicios;

import java.util.Scanner;
public class Ejemplo41 {
	  public static void main (String argv[]) {
			int x =0;
			int y =1;
			int z =0;
			System.out.print(x + "," + y +",");
			for(int i=0;i<38;i++){
				z = x + y;
				x = y;
				y = z;

				System.out.print(z + ",");
			}
    }
}
