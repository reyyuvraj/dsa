package self.leetcode;

import java.util.Arrays;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] k : dp)
            Arrays.fill(k, -1);
        return count(m - 1, n - 1, grid, dp);
    }

    private int count(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];

        if (i < 0 || j < 0) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + count(i - 1, j, grid, dp);
        int left = grid[i][j] + count(i, j - 1, grid, dp);
        int diagonal = grid[i][j] + count(i - 1, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, Math.min(left, diagonal));
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }
}
