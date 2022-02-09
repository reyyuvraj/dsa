package college;

import java.util.Stack;

public class Sample {

    public static void main(String[] args) {
        int[] arr = {15, 7, 5, 6, 10, 4, 1, 5};

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        System.out.println(findStack(stack));
    }

    public static Stack findStack(Stack inIntStack) {
        Stack outIntStack = new Stack();

        if (inIntStack.isEmpty()) {
            return null;
        }

        int number = 1;

        while (!inIntStack.isEmpty()) {
            outIntStack.push((int) inIntStack.pop() + number);
            number += 1;
            int temp = (int) inIntStack.pop();
            if (((int) outIntStack.peek()) % temp == 0) {
                outIntStack.push(inIntStack.pop());
            } else {
                outIntStack.push(temp / number);
            }
        }
        return outIntStack;
    }
}
