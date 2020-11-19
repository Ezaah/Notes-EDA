import java.util.*;
import java.io.*;

public class graphs {

    public static void dfs(int v, ArrayList<Integer>[] lista, boolean[] visitados){
        if(visitados[v]){
            return;
        }
        visitados[v] = true;
        System.out.println("Visitando " + (v+1));
        for(int i = 0; i < lista[v].size(); i++){
            dfs(lista[v].get(i), lista, visitados);
        }
        
    }
    public static void main(String[] args){
        
        int vertices = 5;
        ArrayList<Integer>[] lista = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++){
            lista[i] = new ArrayList<Integer>();
        }

        // Vertice 1
        lista[0].add(1);
        lista[1].add(0);
        lista[0].add(2);
        lista[2].add(0);
        // Vertice 2
        lista[1].add(2);
        lista[2].add(1);
        // Vertice 3
        lista[2].add(3);
        lista[3].add(2);
        // Vertice 4
        lista[3].add(4);
        lista[4].add(3);
        // Vertice 5
        lista[4].add(1);
        lista[1].add(4);

        // BFS Iterativo
        // Queue<Integer> cola = new LinkedList<Integer>();
        // cola.add(0);
        // boolean[] visitados = new boolean[vertices];
        // for(int i = 0; i < vertices; i++){
        //     visitados[i] = false;
        // }

        // while(cola.size() > 0){
        //     int v = cola.peek();
        //     cola.remove();
        //     if(visitados[v]){
        //         continue;
        //     }
        //     visitados[v] = true;
        //     System.out.println("Visitando " + (v + 1));
        //     for(int i = 0; i < lista[v].size(); i++){
        //         cola.add(lista[v].get(i));
        //     }
        // }

        // DFS Iterativo
        // Stack<Integer> pila = new Stack<Integer>();
        // boolean[] visitados = new boolean[vertices];
        // for(int i = 0; i < vertices; i++){
        //     visitados[i] = false;
        // }
        // pila.push(0);
        // while(pila.size() > 0){
        //     int v = pila.peek();
        //     pila.pop();
        //     if(visitados[v]){
        //         continue;
        //     }
        //     visitados[v] = true;
        //     System.out.println("Visitando " + (v+1));
        //     for(int i = 0; i < lista[v].size(); i++){
        //         pila.push(lista[v].get(i));
        //     }
        // }

        // DFS recursivo
        boolean[] visitados = new boolean[vertices];
        for(int i = 0; i < vertices; i++){
            visitados[i] = false;
        }
        dfs(0, lista, visitados);

    }
}
