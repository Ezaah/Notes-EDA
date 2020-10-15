import java.util.*;
import java.io.*;

public class heap {

    static class Heap{
        ArrayList<Integer> valores;

        Heap(){
            valores = new ArrayList<Integer>();
            valores.add(1000000);
        }

        int left(int pos){
            return 2*pos;
        }

        int right(int pos){
            return 2*pos + 1;
        }

        int padre(int pos){
            return pos/2;
        }

        void swap(int a, int b){
            int temp = valores.get(a);
            valores.set(a, valores.get(b));
            valores.set(b, temp);
        }

        // Busqueda del minimo es O(1)
        public int getMin(){
            return valores.get(1);
        }


        // Insert es log(n)
        public void insert(int valor){
            valores.add(valor);
            int pos = valores.size() - 1;

            while(pos != 1 && valores.get(pos) < valores.get(padre(pos))){
                swap(pos, padre(pos));
                pos = padre(pos);
            }
        }

        // Delete es log(n)
        public void deleteMin(){
            swap(1, valores.size() - 1);
            valores.remove(valores.size() - 1);
            mantenerHeap(1);
        }

        void mantenerHeap(int pos){
            int min_pos = pos;

            if(left(pos) < valores.size() && valores.get(left(pos)) < valores.get(min_pos)){
                min_pos = left(pos);
            }

            if(right(pos) < valores.size() && valores.get(right(pos)) < valores.get(min_pos)){
                min_pos = right(pos);
            }
            if(min_pos == pos){
                return;
            }
            swap(pos, min_pos);
            mantenerHeap(min_pos);

        }

        public void print(){
            for(int i = 1; i < valores.size(); i++){
                System.out.print(valores.get(i) + " ");
            }
            System.out.print("\n");
        }

    }

    // Heapsort:
    //  nlog(n) + nlog(n) = nlog(n)
    static void heapsort(ArrayList<Integer> valores){
        Heap arbol = new Heap();
        for(int i = 0; i < valores.size(); i++ ){
            arbol.insert(valores.get(i));
        }

        for(int i = 0; i < valores.size(); i++){
            System.out.print(arbol.getMin() + " ");
            arbol.deleteMin();
        }
    }



    public static void main(String[] args){
        // Heap arbol = new Heap();
        ArrayList<Integer> valores = new ArrayList<Integer>();
        
        // arbol.insert(10);
        // arbol.print();
        // arbol.insert(15);
        // arbol.print();
        // arbol.insert(5);
        // arbol.print();
        // arbol.insert(1);
        // arbol.print();

        // arbol.insert(6);
        // arbol.print();
        // arbol.insert(7);
        // arbol.print();
        // arbol.insert(-1);
        // arbol.print();

        valores.add(10);
        valores.add(15);
        valores.add(5);
        valores.add(1);
        valores.add(6);
        valores.add(7);
        valores.add(-1);
        heapsort(valores);
    }
}
