package lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
        if (a.length == 0) return 0;
        int counter = 1, result = 1;
        for (int i = 1; i < a.length; i++) {
            if ((a[i]>0 && a[i-1]<0) || (a[i]<0 && a[i-1]>0)){
                counter++;
                result = Math.max(counter,result);
            } else {
                counter = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
