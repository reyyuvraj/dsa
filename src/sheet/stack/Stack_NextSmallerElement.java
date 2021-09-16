package sheet.stack;

import java.util.Stack;

public class Stack_NextSmallerElement {

    public static void printNSE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);

        for (int i = 1; i < n; i++) {

            if (st.empty()) {
                st.push(arr[i]);
                continue;
            }

            while (!st.empty() && st.peek() > arr[i]) {
                System.out.println(st.peek() + " --> " + arr[i]);
                st.pop();
            }
            st.push(arr[i]);
        }
        while (!st.empty()) {
            System.out.println(st.peek() + " --> " + "-1");
            st.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 3, 10, 15};
        int n = arr.length;
        printNSE(arr, n);
    }
}
