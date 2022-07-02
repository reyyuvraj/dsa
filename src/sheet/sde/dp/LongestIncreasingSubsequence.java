package sheet.sde.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int maxProduct(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        return helper(0, -1, arr, n, dp);
    }

    private int helper(int ind, int prev_ind, int[] arr, int n, int[][] dp) {
        if (ind == n) return 0;

        if (dp[ind][prev_ind + 1] != 1) return dp[ind][prev_ind + 1];

        int len = helper(ind + 1, prev_ind, arr, n, dp);

        if (prev_ind == -1 || arr[ind] > arr[prev_ind])
            len = Math.max(len, 1 + helper(ind + 1, ind, arr, n, dp));

        return dp[ind][prev_ind+1] = len;
    }

    public static void main(String[] args) {

    }
}
