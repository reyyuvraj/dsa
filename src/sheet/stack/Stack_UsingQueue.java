package sheet.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_UsingQueue {

    static class StackUsingQueue {

        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        static int curr_size;

        StackUsingQueue() {
            curr_size = 0;
        }

        static void push(int x) {
            curr_size++;

            q2.add(x);

            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }

            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        static void pop() {
            if (q1.isEmpty())
                return;
            q1.remove();
            curr_size--;
        }

        static int top() {
            if (q1.isEmpty())
                return -1;
            return q1.remove();
        }

        static int size() {
            return curr_size;
        }
    }

    public static void main(String[] args) {
        StackUsingQueue.push(1);
        StackUsingQueue.push(2);
        StackUsingQueue.push(3);

        System.out.println("Current size : "+StackUsingQueue.size());
        System.out.println(StackUsingQueue.top());
        StackUsingQueue.pop();

        System.out.println("Current size : "+StackUsingQueue.size());
    }
}
