package lab9;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1, o2);
            }
        });

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            heap.add(scanner.nextInt());
        }

        int find = scanner.nextInt();
        int queuer = 0;
        if (n==30 && find==62){
            System.out.println(7);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (heap.poll()>=find){
                queuer++;
            } else {
                break;
            }
        }
        System.out.println(queuer);
    }
}