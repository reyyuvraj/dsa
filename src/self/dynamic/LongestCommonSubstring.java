package self.dynamic;

public class LongestCommonSubstring {

    public static int lcs(String str1, String str2) {

        int m = str1.length(), n = str2.length(), max = 0;

        int[][] dp = new int[m + 1][n + 1];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    if (dp[i + 1][j + 1] > max) {
                        max = dp[i + 1][j + 1];
                        idx = i;
                    }
                } else
                    dp[i + 1][j + 1] = 0;
            }
        }

        //for printing string needs correction ->
        String sub = str1.substring(idx - max + 1, idx + 1);
        System.out.println(sub);

        return max;
    }

    public static int lcsN(String str1, String str2) {
        int m = str1.length(), n = str2.length(), max = 0;
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        int idx = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    int value = 1 + prev[j - 1];
                    cur[j] = value;
                    max = Math.max(max, value);
                } else
                    cur[j] = 0;
            }
            prev = cur;
        }
        //for printing string needs correction ->
        String sub = str1.substring(idx - max + 1, idx + 1);
        System.out.println(sub);

        return max;
    }

    public static void main(String[] args) {
        String str1 = "aacabdkacaa", str2 = new StringBuffer(str1).reverse().toString();//"acjkp"
        System.out.println(lcsN(str1, str2));
    }
}
