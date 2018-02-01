package Ejercicios;

import java.util.Random;
import java.util.Arrays;
public class Ejercicio10 {
    public static void rellenaMatriz(int[][] matriz, int max){
        Random aleatorio = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y (max-1)
        int intAleatorio;
        int filas = matriz.length;
        int columnas = matriz[0].length;
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                matriz[i][j] = aleatorio.nextInt(max);
            }
        }
    }    

    public static void main(String[] args) {
        int[][]  matriz = new int[4][4];
        rellenaMatriz(matriz, 2);
        int contfil =0;
        int contfiltot =0;    
        int contcol =0;
        int contcoltot =0;
        System.out.println("matriz : "+Arrays.deepToString(matriz));
        for(int i=0; i<matriz.length;i++) {
        	for(int j=0; j<matriz[i].length;j++) {
        		System.out.print(matriz[i][j] + " ");
        		if(matriz[i][j]==1) {
        			contfil = 0;
        			
        		}else {
        			contfil++;
        		}
        		if(contfil==matriz.length) {
        			contfiltot++;
        		}
        		if(matriz[j][i]==1) {
        			contcol = 0;
        			
        		}else {
        			contcol++;
        		}
        		if(contcol==matriz[j].length) {
        			contcoltot++;
        		}
            }   
        	System.out.println();
        	}
        if(contfiltot>0) {
        	System.out.println("Hay " + contfiltot +" filas con todos sus valores a 0");
        }else {
        	System.out.println("No hay filas con todos sus valores a 0");
        }
        if(contcoltot>0) {
        	System.out.println("Hay " + contcoltot +" columnas con todos sus valores a 0");
        }else {
        	System.out.println("No hay columnas con todos sus valores a 0");
        }
    }
}