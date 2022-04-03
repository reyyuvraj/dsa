package self.miscellaneous;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindow {

    static int maximum(int[] arr, int start, int end) {
        int i = start, j = 0;
        int[] a = new int[end - start + 1];
        while (i <= end) {
            a[j] = arr[i];
            i++;
            j++;
        }
        Arrays.sort(a);
        return a[a.length - 1];
    }

    static void window(int[] arr, int w) {
        for (int i = 0; i < arr.length - w + 1; i++) {
            System.out.print(maximum(arr, i, i + w - 1) + " ");
        }
    }

    static int[] sliding(int[] arr, int k) {
        int n = arr.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (!q.isEmpty() && q.peek() == i - k)
                q.poll();

            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }

            q.offer(i);

            if (i >= k - 1) {
                r[ri++] = arr[q.peek()];
            }
        }

        return r;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        window(arr, 1);
    }

}