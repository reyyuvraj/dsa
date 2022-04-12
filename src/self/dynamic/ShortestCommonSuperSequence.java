package self.dynamic;

public class ShortestCommonSuperSequence {

    public String longestCommonSubsequence(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        int i = m, j = n;
        StringBuilder res = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                res.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res.append(s.charAt(i - 1));
                i--;
            } else {
                res.append(t.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            res.append(s.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            res.append(t.charAt(j - 1));
            j--;
        }

        return res.reverse().toString();
    }

    public String shortestCommonSuperSequence(String str1, String str2) {
        return longestCommonSubsequence(str1, str2);
    }

    public static void main(String[] args) {
        String str1 = "bleed", str2 = "blue";//"bbbaaaba""bbababbb"
        System.out.println(new ShortestCommonSuperSequence().shortestCommonSuperSequence(str1, str2));
    }
}
