package sheet.sde.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MatrixChainMultiplication {

    static int matrixMultiplication(int N, int[] arr) {
        int[][] dp = new int[N][N];
        for (int[] ar : dp)
            Arrays.fill(ar, -1);

        return chainMultiplication(1, N - 1, arr, dp);
    }

    static int chainMultiplication(int i, int j, int[] arr, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int mini = (int) 10e9;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j]
                    + chainMultiplication(i, k, arr, dp)
                    + chainMultiplication(k + 1, j, arr, dp);

            mini = Math.min(mini, steps);
            dp[i][j] = mini;
        }

        return dp[i][j] = mini;
    }

    public static void main(String[] args) {
        int[] a = {40, 20, 30, 10, 30};
        int[] b = {10, 30, 5, 60};
        System.out.println(matrixMultiplication(4, b));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
}
