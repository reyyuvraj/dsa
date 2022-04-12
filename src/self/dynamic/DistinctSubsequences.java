package self.dynamic;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return helperMemoization(s.length() - 1, n - 1, s, t, dp);
    }

    private int helperMemoization(int i, int j, String s, String t, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j))
            return dp[i][j] = helperMemoization(i - 1, j - 1, s, t, dp) + helperMemoization(i - 1, j, s, t, dp);

        return dp[i][j] = helperMemoization(i - 1, j, s, t, dp);
    }

    private int helperTabulation(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    private int helperOptimization(String s, String t) {
        int n = s.length(), m = t.length();
        int[] pre = new int[m + 1];

        pre[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    pre[j] = pre[j - 1] + pre[j];
            }
        }
        return pre[m];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(new DistinctSubsequences().numDistinct(s, t));
    }
}
