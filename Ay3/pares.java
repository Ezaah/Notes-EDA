import java.util.*;
import java.io.*;

public class pares {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array); // Ordena de menor a mayor. O(nlog(n))

        int i = 0;
        int j = n-1;

        while(i < j){
            if(array[i] + array[j] == k){
                System.out.println(array[i] + " " + array[j]);
                break;
            }
            
            if(array[i] + array[j] < k){
                i++;
            }else{
                j--;
            }
        }
    }
}
