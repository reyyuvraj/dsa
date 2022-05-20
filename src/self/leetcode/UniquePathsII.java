package self.leetcode;

import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return uniquePaths(obstacleGrid, n - 1, m - 1, dp);
    }

    private int uniquePaths(int[][] arr, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (arr[i][j] == 1) return 0;

        if (i == 0 && j == 0) return 1;

        int left = uniquePaths(arr, i, j - 1, dp);
        int up = uniquePaths(arr, i - 1, j, dp);

        return dp[i][j] = left + up;
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }
}
