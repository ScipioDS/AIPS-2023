package FirstPartialExercises;

import java.util.Arrays;
import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {
        int [] LIS = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            LIS[i]=1;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i]<a[j]){
                    if (LIS[i] < LIS[j]+1){
                        LIS[i] = LIS[j]+1;
                    }
                }
            }
        }
        int result = 1;
        for (int i = 0; i < LIS.length; i++) {
            if (LIS[i]>result){
                result = LIS[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
