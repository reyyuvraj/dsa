package sheet.sde.stacknqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public int[] prevSmaller(int[] A) {
        Stack<Integer> min = new Stack<>();
        int n = A.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            while (!min.empty() && min.peek() >= A[i]) {
                min.pop();
            }

            if (min.empty()) res[i] = -1;
            else res[i] = min.peek();

            min.push(A[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {39, 27, 11, 4, 24, 32, 32, 1};
        System.out.println(Arrays.toString(new NextSmallerElement().prevSmaller(arr)));
    }
}
