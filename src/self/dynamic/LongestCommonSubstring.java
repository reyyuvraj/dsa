package self.dynamic;

public class LongestCommonSubstring {

    public static int lcs(String str1, String str2) {

        int m = str1.length(), n = str2.length(), max = 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    max = Math.max(dp[i + 1][j + 1], max);
                } else
                    dp[i + 1][j + 1] = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String str1 = "abcjklp", str2 = "acjkp";
        System.out.println(lcs(str1, str2));
    }
}
