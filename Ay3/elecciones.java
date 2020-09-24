import java.util.*;
import java.io.*;

public class elecciones {
    
    static class Candidato{
        public int id;
        public int votos;
    }

    static class Comparador implements Comparator<Candidato>{
        public int compare(Candidato a, Candidato b){
            // Debe retornar:
            // -1  Si  a < b (a debe ir antes que b)
            //  0  si  a = b
            //  1  si  a > b (a debe ir despues que b)

            if(a.votos > b.votos){
                return -1;
            }else if(a.votos < b.votos){
                return 1;
            }else{
                if(a.id < b.id){
                    return -1;
                }else{
                    return 1;
                }
            }
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sitios = sc.nextInt();

        Candidato[] candidatos = new Candidato[n];
        for(int i = 0; i < n; ++i){
            candidatos[i] = new Candidato();
            candidatos[i].id = i+1;
            candidatos[i].votos = 0;
        }
        int total_votos = 0;
        for(int i = 0; i < sitios; ++i){
            float[] porcentajes = new float[n];
            int votos = 0;
            for(int j = 0; j < n; ++j){
                porcentajes[j] = sc.nextFloat()/100;
            }
            votos = sc.nextInt();
            total_votos += votos;
            for(int j = 0; j < n; ++j){
                candidatos[j].votos += votos*porcentajes[j];
            }
        }

        for(int i = 0; i < n; ++i){
            System.out.println("Candidato " + candidatos[i].id + ": " + candidatos[i].votos);
        }
        System.out.println("Ordenando!");
        Arrays.sort(candidatos, new Comparador());

        for(int i = 0; i < n; ++i){
            System.out.println("Candidato " + candidatos[i].id + ": " + candidatos[i].votos);
        }

        if(candidatos[0].votos >= 0.501*total_votos){
            System.out.println(candidatos[0].id + " " + candidatos[0].votos);
        }else{
            System.out.println(candidatos[0].id + " " + candidatos[0].votos);
            System.out.println(candidatos[1].id + " " + candidatos[1].votos);
        }
    }
}
