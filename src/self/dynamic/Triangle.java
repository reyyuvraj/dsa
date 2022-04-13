package self.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TriangleMemoization {
    public int min(ArrayList<ArrayList<Integer>> tr, int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0] = tr.get(0).get(0);
        return min(0, 0, tr.get(0).get(0), dp, tr, n);
    }

    public int min(int i, int j, int sum, int[][] dp, ArrayList<ArrayList<Integer>> tr, int n) {
        if (i == n - 1) {
            return sum;
        }

        if (i >= n || j >= n)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int down = min(i + 1, j, sum + tr.get(i + 1).get(j), dp, tr, n);
        int right = min(i + 1, j + 1, sum + tr.get(i + 1).get(j + 1), dp, tr, n);

        return dp[i][j] = Math.min(down, right);
    }

    public int minimumTotal(List<List<Integer>> t) {//tabulation
        int n = t.size();
        int[][] dp = new int[n][n];

        for(int j = 0;j<n;j++)
            dp[n-1][j] = t.get(n-1).get(j);

        for(int i = n-2;i>=0;i--){
            for(int j = i;j>=0;j--){
                int value = t.get(i).get(j);
                int down = value + dp[i+1][j];
                int diagonal = value + dp[i+1][j+1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}

class TriangleRecursion {
    public int min(ArrayList<ArrayList<Integer>> tr, int n) {
        return min(0, 0, tr.get(0).get(0), tr, n);
    }

    public int min(int i, int j, int sum, ArrayList<ArrayList<Integer>> tr, int n) {
        if (i == n - 1) {
            return sum;
        }

        if (i >= n || j >= n)
            return 0;

        int down = min(i + 1, j, sum + tr.get(i + 1).get(j), tr, n);
        int right = min(i + 1, j + 1, sum + tr.get(i + 1).get(j + 1), tr, n);

        return Math.min(down, right);
    }
}

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> tr = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    int num = in.nextInt();
                    temp.add(num);
                }
                tr.add(temp);
            }
            // recursion
            TriangleRecursion tRec = new TriangleRecursion();
            System.out.println(tRec.min(tr, n));
            //memoization
            TriangleMemoization tMemo = new TriangleMemoization();
            System.out.println(tMemo.min(tr, n));
            t--;
        }
    }
}
