import java.util.*;
import java.io.*;

public class ordenemos {

    static class Comparador implements Comparator<Integer>{
        public int mod;

        Comparador(int m){
            this.mod = m;
        }
            
        // Debe retornar:
        // -1  Si  a < b (a debe ir antes que b)
        //  0  si  a = b
        //  1  si  a > b (a debe ir despues que b)
        public int compare(Integer a, Integer b){

            if( a % mod < b % mod ){
                return -1; // a va primero.
            }else if(a % mod > b % mod){
                return 1; // a va despues.
            }else{
                if(a % 2 == 1 && b % 2 == 0){
                    return -1; // a va primero porque es impar.
                }else if(a % 2 == 0 && b % 2 == 1){
                    return 1; // a va despues porque es par.
                }else if(a % 2 == 1 && b % 2 == 1){
                    if(a > b){
                        return -1; // a va primero porque es mas grande
                    }else{
                        return 1; // a va despues.
                    }
                }else if(a % 2 == 0 && b % 2 == 0){
                    if(a < b){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }

            return 0;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Integer[] valores = new Integer[n];
        for(int i = 0; i < n; i++){
            valores[i] = sc.nextInt();
        }

        Arrays.sort(valores, new Comparador(m));

        for(int i = 0; i < n; i++){
            System.out.println(valores[i]);
        }
    }
}
