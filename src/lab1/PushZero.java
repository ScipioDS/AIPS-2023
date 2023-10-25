package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int [] temp = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            temp[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]!=0){
                temp[count++]=arr[i];
            }
        }
        arr = temp;
        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
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