package self.dynamic;

public class LongestCommonSubsequence {

    // tabulation
    public static int longestCommonSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (s.charAt(i) == t.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);

        int len =   dp[m][n];

        char[] sub = new char[dp[m][n]];

        int index = len -1;
        int i = m, j = n;
        while (i>0 && j>0){
            if (s.charAt(i-1)==t.charAt(j-1)){
                sub[index] = s.charAt(i-1);
                index--;
                i--;j--;
            } else if (dp[i-1][j]>dp[i][j-1]){
                i--;
            } else j--;
        }

        System.out.println(new String(sub));

        return len;
    }

    public static void main(String[] args) {
        String s = "asdasdfasf", t = "asdasdaa";
        System.out.println(longestCommonSubsequence(s, t));
    }
}
