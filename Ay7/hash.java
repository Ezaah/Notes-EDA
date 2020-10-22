import java.util.*;
import java.io.*;

public class hash {
    public static void main(String[] args){
        int[] valores = {1,5,7,3,4,2};
        int k = 6;

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < valores.length; i++){
            set.add(valores[i]);
        }

        for(int i = 0; i < valores.length; i++){
            // for(int j = 0; j < valores.length; j++)
            if(set.contains(k - valores[i])){
                System.out.println(valores[i] + " "  + (k - valores[i]));
            }
        }
        System.out.println(" Usando Hashmap \n");
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0; i < valores.length; i++){
            map.put(valores[i], i);
        }
        
        for(int i = 0; i < valores.length; i++){
            if(map.containsKey(k - valores[i])){
                if(map.get(k - valores[i]) < i){
                    System.out.println(valores[i] + " " + (k - valores[i]));
                }
            }
        }


    }
}
