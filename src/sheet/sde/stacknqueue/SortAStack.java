package sheet.sde.stacknqueue;

import java.util.Arrays;
import java.util.Stack;

public class SortAStack {

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.empty()) {
            int x = stack.pop();

            sortStack(stack);

            sortedInsert(stack, x);
        }
    }

    static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x < s.peek()) {
            s.push(x);
            return;
        }

        int temp = s.pop();
        sortedInsert(s, x);

        s.push(temp);
    }

    public static void main(String[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        sortStack(stack);
        System.out.println(Arrays.toString(stack.toArray()));
    }
}
