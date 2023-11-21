package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {
    static void printArray(int a[],int n){
        for (int j = 0; j < n; j++) {
            System.out.print(a[j]+" ");
        }
        System.out.print("\n");
    }

    static void shakerSort(int a[], int n)
    {
        boolean flag = false;
        for (int i = 0; i < n - i; i++) {
            flag = false;
            for (int j = n - i - 1; j > i; j--) {
                if (a[j] < a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    flag = true;
                }
            }
            printArray(a,n);
            for (int j = i; j < n - i - 1; j++) {
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            printArray(a,n);
            if (!flag) break;
        }
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        shakerSort(a,n);
    }
}