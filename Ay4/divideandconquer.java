import java.util.*;
import java.io.*;

public class divideandconquer {
    public static void quicksort(int[] arreglo, int inicio, int fin){

        if(fin - inicio < 1){
            return;
        }

        int pivote = pivot(arreglo, inicio, fin);
        // System.out.println(inicio + " " + fin + " pivote: " + pivote);
        quicksort(arreglo, inicio, pivote - 1);
        quicksort(arreglo, pivote +1, fin);
    }

    public static int pivot(int[] arreglo, int inicio, int fin){
        Random rn = new Random();

        int posicion_pivote = rn.nextInt(fin - inicio + 1) + inicio;
        int pivote_value = arreglo[posicion_pivote];

        int posicion_final = inicio;
        for(int i = inicio; i <= fin; ++i){
            if(arreglo[i] <= pivote_value && posicion_pivote != i){
                if(posicion_final == posicion_pivote){
                    posicion_pivote = i;   
                }
                swap(arreglo, i, posicion_final);
                posicion_final++;

                
            }
        }
        swap(arreglo, posicion_pivote, posicion_final);
        return posicion_final;
    }

    public static void swap(int[] arreglo, int i, int j){
        int aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }


    public static void main(String[] args){
        int[] arreglo = {5,7,1,3,2};

        for(int i = 0; i < arreglo.length; i++){
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();

        quicksort(arreglo, 0, arreglo.length - 1);

        for(int i = 0; i < arreglo.length; i++){
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}
