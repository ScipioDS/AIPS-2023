import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddEvenSort {
    static void sortnumbers(int a[], int n, boolean type){
        if (type) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (a[j] > a[j+1]){
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (a[j] < a[j+1]){
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                    }
                }
            }
        }

    }
    static void oddEvenSort(int a[], int n){
        Arrays.sort(a);
        int [] odd = new int[n];
        int [] even = new int[n];
        int oddcounter = 0;
        int evencounter = 0;
        for (int i = 0; i < n; i++) {
            if (a[i]%2==1) {
                odd[oddcounter++] = a[i];
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (a[i]%2==0) {
                even[evencounter++] = a[i];
            }
        }
        sortnumbers(odd,oddcounter,true);
        sortnumbers(even,evencounter,false);
        int j=0;
        for (int i = 0; i < n; i++) {
            if (i < oddcounter){
                a[i] = odd[i];
            } else {
                a[i] = even[j++];
            }
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
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}