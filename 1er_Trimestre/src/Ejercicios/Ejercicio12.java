package Ejercicios;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio12 {
    public static void createShips(int numShips, int[][] shipPlaces) {
    int r1, r2;
    int cont = 0;

    while (cont<numShips) {
        r1 = (int) (Math.random()*8);
        r2 = (int) (Math.random()*8);
        if (shipPlaces[r1][r2] != 1) {
            shipPlaces[r1][r2]=1;
            cont++;
        }
    }
}
  public static int cuantosHundidos(int matriz [][]){
    int cuantos = 0;
    //Con un for cuantas cuÃ¡ntos 2 hay
    for(int i=0; i < matriz.length; i++){
      for(int j=0; j < matriz[0].length;j++){
          if(matriz[i][j]==2){
            cuantos++;
          }
      }
    }
    return cuantos;
  }
  public static void printTablero(int matriz [][]){
    String c = "Â·";
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
          actual = " ";
        }
        if(matriz[i][j]==1){
          actual = " ";
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
    char fila;
    int filaNumero;
    int columna;
    int[][] shipPlaces=new int[8][8];
    int contadorHundidos = 0;
    int tiros=0;
    createShips(10, shipPlaces);

    printTablero(shipPlaces);
    Scanner inputValue;
    inputValue = new Scanner(System.in);
    //TODO TIENE QUE SER UN BUCLE
    do{
      System.out.println("Introduzca las coordenadas de columna (1 - 8): ");
      columna = inputValue.nextInt();
      columna = columna - 1;
      System.out.println("Introduzca las coordenadas de fila (A - H): ");
      fila = inputValue.next().charAt(0);
      filaNumero = fila - 65;
      System.out.println(filaNumero);
      tiros++;
      if(shipPlaces[filaNumero][columna]==1){
        shipPlaces[filaNumero][columna] = 2;
        contadorHundidos++;
      }else if(shipPlaces[filaNumero][columna]==0){
        shipPlaces[filaNumero][columna] = 3;
      }
      printTablero(shipPlaces);
      //contadorHundidos = cuantosHundidos(shipPlaces);
      System.out.println("tiros realizados: "  + tiros);
      System.out.println("Hundidos: "  + contadorHundidos);
    }while(contadorHundidos<10);
    //HASTA AQUÃ�
  }
}
