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
                    if (dp[i+1][j+1]>max){
                        max = dp[i+1][j+1];
                        idx = i;
                    }
                } else
                    dp[i + 1][j + 1] = 0;
            }
        }

        //for printing string needs correction -> String sub = str1.substring(idx-max+1, idx);
        //System.out.println(sub);

        return max;
    }

    public static void main(String[] args) {
        String str1 = "aacabdkacaa", str2 = new StringBuffer(str1).reverse().toString();//"acjkp"
        System.out.println(lcs(str1, str2));
    }
}
