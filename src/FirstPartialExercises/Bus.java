package FirstPartialExercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka
        int minTotal = 0;
        int maxTotal = 0;

        if (M>N && M!=0){
            minTotal = (N*100) + (M-N)*100;
            maxTotal = (N*100) + (M-1)*100;
        } else if (M!=0){
            minTotal = N*100;
            maxTotal = minTotal + (M-1)*100;
        } else {
            minTotal = N*100;
            maxTotal = minTotal;
        }

        System.out.println(minTotal);
        System.out.println(maxTotal);

    }

}
