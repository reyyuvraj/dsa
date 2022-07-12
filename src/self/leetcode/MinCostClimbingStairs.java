package self.leetcode;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return f(n, dp, cost);
    }

    private int f(int i, int[] dp, int[] cost) {
        if (i == 0 || i == 1) return 0;
        if (dp[i] != -1) return dp[i];

        return dp[i] = Math.min(
                f(i - 1, dp, cost) + cost[i - 1],
                f(i - 2, dp, cost) + cost[i - 2]);
    }

    public static void main(String[] args) {
        int[] a = {10, 15, 20};
        int[] b = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(a));
    }
}
