import java.util.*;
import java.io.*;

public class caperucita {
    public static class punto {
        int x;
        int y;

        punto(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void print(int[][] mapa, int largo, int alto){
        for(int i =0; i < largo; i++){
            for(int j = 0; j< alto; j++){
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int topdown(int x, int y, int[][] mapa, int largo,int  alto, punto[] lobos, int numero_lobos){
        // No salirse del mapa
        if(x < 0 || x >= largo){
            return 0;
        }

        if(y < 0 || y >= alto){
            return 0;
        }

        // Caso base caperucita
        if(x == 0 && y == 0){
            mapa[x][y] = 1;
            return 1;
        }

        // Caso Lobos
        for(int i = 0; i < numero_lobos; i++){
            if(lobos[i].x == x && lobos[i].y == y){
                return 0;
            }
        }

        // Ya calculé esta posicion
        if(mapa[x][y] != 0){
            return mapa[x][y];
        }

        int abajo = topdown(x, y-1, mapa, largo, alto, lobos, numero_lobos);
        int izquierda = topdown(x-1, y, mapa, largo, alto, lobos, numero_lobos);
        mapa[x][y] = abajo + izquierda;
        return mapa[x][y];
    }
    public static void main(String[] args){
        int largo = 5;
        int alto = 6;

        int[][] mapa = new int[largo][alto];
        for(int i = 0; i < largo; i++){
            for(int j = 0; j < alto; j++){
                mapa[i][j] = 0;
            }
        }

        print(mapa, largo, alto);

        punto[] lobos = new punto[3];
        lobos[0] = new punto(0,4);
        lobos[1] = new punto(2,4);
        lobos[2] = new punto(2,2);

        topdown(4, 5, mapa, largo, alto, lobos, 3);
        print(mapa, largo, alto);

        for(int i = 0; i < largo; i++){
            for(int j = 0; j < alto; j++){
                mapa[i][j] = 0;
            }
        }
        print(mapa, largo, alto);

        // Bottom Up
        mapa[0][0] = 1;
        for(int i = 0; i < largo; i++){
            for(int j = 0; j < alto; j++){
                boolean lobo = false;
                for(int k = 0; k < 3; k++){
                    if(lobos[k].x == i && lobos[k].y == j){
                        mapa[i][j] = 0;
                        lobo = true;
                    }
                }
                if(lobo || i == 0 && j == 0){
                    continue;
                }

                if(i == 0){
                    mapa[i][j] = mapa[i][j-1];
                }else if(j == 0){
                    mapa[i][j] = mapa[i-1][j];
                }else{
                    mapa[i][j] = mapa[i-1][j] + mapa[i][j-1];
                }
                // System.out.printf("%d %d  => %d\n", i,j,mapa[i][j]);
            }
        }

        print(mapa, largo, alto);



    }
}
