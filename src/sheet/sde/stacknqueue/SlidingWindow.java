package sheet.sde.stacknqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

    public int[] maxSlidingWindow(int[] arr, int k) {
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

    public int[] maxSlidingWindow4ms(int[] arr, int k) {
        int resultArraySize = arr.length - k + 1;
        int[] result = new int[resultArraySize];
        int lastIndexOfMax = -1;

        for (int startIndex = 0, endIndex = k - 1; startIndex < resultArraySize; startIndex++, endIndex++) {
            if (startIndex > 0 && arr[endIndex] >= arr[lastIndexOfMax]) {
                lastIndexOfMax = endIndex;
            } else if (startIndex > lastIndexOfMax) {
                int previousMaxIndex = lastIndexOfMax;
                lastIndexOfMax = startIndex;

                for (int j = startIndex; j <= endIndex; j++) {
                    if (previousMaxIndex >= 0 && arr[previousMaxIndex] - 1 <= arr[j]) {
                        lastIndexOfMax = j;
                        break;
                    }
                    if (arr[lastIndexOfMax] < arr[j]) {
                        lastIndexOfMax = j;
                    }
                }
            }
            result[startIndex] = arr[lastIndexOfMax];
        }

        return result;
    }

    public static int[] slidingWindowMaxOptimized(final int[] arr, final int w) {
        final int[] max_left = new int[arr.length];
        final int[] max_right = new int[arr.length];

        max_left[0] = arr[0];
        max_right[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            max_left[i] = (i % w == 0) ? arr[i] : Math.max(max_left[i - 1], arr[i]);

            final int j = arr.length - i - 1;
            max_right[j] = (j % w == 0) ? arr[j] : Math.max(max_right[j + 1], arr[j]);
        }

        final int[] sliding_max = new int[arr.length - w + 1];
        for (int i = 0, j = 0; i + w <= arr.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }
}
