package lab1;
import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            String word = scanner.next();
            printReversed(word);
        }
    }
    public static void printReversed(String word) {
        char ch;
        String new_word = "";
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            new_word = ch + new_word;
        }
        System.out.println(new_word);
    }
}
