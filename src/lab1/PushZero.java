package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int [] temp = new int[n];
        int j=0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                temp[j++]=0;
            }
        }
        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            if (arr[i]!=0){
                temp[j++]=arr[i];
            }
            System.out.print(temp[i] + " ");
        }
        arr = temp;
    }

    public static void main (String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr[i] = x;
        }
        pushZerosToBeginning(arr,n);
    }
}