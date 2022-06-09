package sheet.stack;

import java.util.Stack;

public class Stack_LargestHistogramArea {

    public static int getMaxArea(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int res = 0, tp, curr;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                tp = s.peek();
                s.pop();
                curr = arr[tp] * (s.isEmpty() ? -1 : i - s.peek() - 1);
                res = Math.max(res, curr);
            }
            s.add(i);
        }
        while (!s.isEmpty()) {
            tp = s.peek();
            s.pop();
            curr = arr[tp] * (s.isEmpty() ? n : n - s.peek() - 1);
            res = Math.max(res, curr);
        }
        return res;
    }

    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        Integer one;
        int len = arr.length, max = 0;
        int[] leftSmaller = new int[len];
        int[] rightSmaller = new int[len];

        for (int i = 0; i < len; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.empty()) leftSmaller[i] = 0;
            else leftSmaller[i] = st.peek() + 1;
            st.push(i);
        }

        while (!st.empty()) st.pop();

        for (int i = len - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.empty()) rightSmaller[i] = len - 1;
            else rightSmaller[i] = st.peek() - 1;
            st.push(i);
        }

        for (int i = 0; i < len; i++)
            max = Math.max((rightSmaller[i] - leftSmaller[i] + 1)*arr[i], max);


        return max;
    }

    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 4, 1, 5, 6};

        System.out.println("Maximum Area: " + getMaxArea(arr, arr.length));
        System.out.println(new Stack_LargestHistogramArea().largestRectangleArea(arr));
    }
}
