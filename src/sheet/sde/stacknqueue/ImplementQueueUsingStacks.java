package sheet.sde.stacknqueue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public ImplementQueueUsingStacks() {
        input = new Stack<>();
        output =  new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
            return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
