package sheet.sde.dp;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumCostToCutStick {

    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[][] dp = new int[len + 1][len + 1];

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : cuts)
            hashSet.add(num);

        for (int[] ar : dp)
            Arrays.fill(ar, len + 1);

        return f(0, len, dp, hashSet, len);
    }

    private int f(int i, int j, int[][] dp, HashSet<Integer> hashSet, int len) {
        if (i == j) return 0;

        for (int k = i; k < j; k++) {
            int cost = len + 1;
            if (hashSet.contains(k))
                cost = j + f(i, k, dp, hashSet, len) + f(k, j, dp, hashSet, len);
            dp[k][j] = Math.min(dp[i][j], cost);
        }

        return 0;
    }

    private int help(int[][] dp, HashSet<Integer> hashSet, int len) {

        for (int i = len - 1; i >= 0 ; --i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE: dp[i][j],0 );
                }

            }
        }

        return 0;
    }
}
