import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Calculator {

    /** Calculator solves simple operation with + and - .
     * Program uses ArrayDeque as a stack.
     * Example input:       1 - 3 + 2 + 4
     * Output:              4
     * */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(evaluate(input));
    }

    public static int evaluate(final String input) {
        String[] parts = input.split(" ");
        final Deque<String> stack = new ArrayDeque<>();
        for(String s: parts) {                                          //adds all parts to the stack
            stack.add(s);
        }

        while(stack.size()>1) {
            final int leftValue = Integer.parseInt(stack.pop());
            final String operator = stack.pop();
            final int rightValue = Integer.parseInt(stack.pop());

            int result = 0;
            switch(operator) {
                case "+":
                    result = leftValue + rightValue; break;
                case "-":
                    result = leftValue - rightValue; break;
            }
            stack.push(String.valueOf(result));                     //put the result on the stack
        }
        return Integer.parseInt(stack.pop());                       //if there is only one element on the stack
    }
}
