package FirstPartialExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {
    public static int evaluateExpression(String expression){
        char [] tokens = expression.toCharArray();

        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> values = new Stack<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] >= '0' && tokens[i] <= '9'){
                String number = "";

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    number+=tokens[i++];

                values.push(Integer.parseInt(number));
                i--;
            }

            else if (tokens[i] == '+' || tokens[i] == '*') {

                while (!operators.empty() && hasPrecedence(tokens[i],operators.peek())){
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }

                operators.push(tokens[i]);
            }

        }
        while (!operators.empty())
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        return values.pop();

    }
    public static boolean hasPrecedence(char op1, char op2) {
        if (op1 == '+' && op2 == '*')
            return true;
        else
            return false;
    }
    public static int applyOperation(char operator, int b, int a) {
        if (operator=='+'){
            return a + b;
        } else if (operator == '*'){
            return a * b;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}