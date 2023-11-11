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
        int maxTotal = (N*100) + (M-1)*100, minTotal = N*100;
        if (M>N && M!=0){ minTotal += (M-N)*100;}
        else if (M==0) { maxTotal = minTotal;}

        System.out.println(minTotal + "\n" + maxTotal);
    }

}
