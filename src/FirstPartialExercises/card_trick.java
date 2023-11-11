package FirstPartialExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class card_trick {
    public static int count(int N){
        LinkedList<Integer> deck = new LinkedList<Integer>();
        for (int i = 1; i <= 51; i++) {
            deck.add(i);
        }
        int counter = 0;
        while (deck.get(0) != N){
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < 7; i++) {
                stack.push(deck.getFirst());
                deck.removeFirst();
            }
            boolean flag = true;
            for (int i = 0; i < 14; i++) {
                if (flag){
                    deck.addLast(stack.pop());
                    flag = false;
                } else {
                    int tmp = deck.getFirst();
                    deck.removeFirst();
                    deck.addLast(tmp);
                    flag = true;
                }
            }
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}