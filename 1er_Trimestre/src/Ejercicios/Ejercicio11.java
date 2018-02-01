package Ejercicios;

import java.util.Arrays;
import java.util.Random;
public class Ejercicio11{

  public static void rellenaTablero(int[][] matriz, int max){
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
  public static void printTablero(int matriz [][]){
    String c = "·";
    String u ="+";
    String d = "O";
    String t = "X";
    String actual = "";
    String letras[]={"A","B","C","D","E","F","G","H"};
    System.out.print("  ");
    for(int i=1; i <= matriz.length; i++){
      System.out.print(i + " ");
    }
    System.out.println("");
    for(int i=0; i < matriz.length; i++){
      System.out.print(letras[i] + " ");
        for(int j=0; j < matriz[0].length;j++){
        //  System.out.print(matriz[i][j] + " ");
          if(matriz[i][j]==0){
            actual = c;
          }
          if(matriz[i][j]==1){
            actual = u;
          }
          if(matriz[i][j]==2){
            actual = d;
          }
          if(matriz[i][j]==3){
            actual = t;
          }
          System.out.print(actual + " ");
        }
        System.out.println();
    }
  }
  public static void main(String[] args) {
    int[][]  matriz = new int[8][8];
    rellenaTablero(matriz, 4);
    printTablero(matriz);
  }
}
