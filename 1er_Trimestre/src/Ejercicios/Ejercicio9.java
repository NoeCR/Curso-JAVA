package Ejercicios;

import java.util.Random;
import java.util.Arrays;
public class Ejercicio9 {
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
        int[][]  matriz = new int[10][10];
        rellenaMatriz(matriz, 2);

        System.out.println("matriz : "+Arrays.deepToString(matriz));
        for(int i=0; i<matriz.length;i++) {
        	for(int j=0; j<matriz.length; j++) {
        		System.out.print(matriz[i][j] + " ");
        	}
        	System.out.println();
        }
    }
}
