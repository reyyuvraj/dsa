package self.leetcode;

import java.util.Arrays;

public class CherryPickupII {

    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][][] dp = new int[r][c][c];

        for (int[][] j : dp) {
            for (int[] i : j)
                Arrays.fill(i, -1);
        }

        return f(0, 0, c - 1, r, c, grid, dp);
    }

    public int f(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
            return Integer.MIN_VALUE;

        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += f(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        System.out.println(new CherryPickupII().cherryPickup(arr));
    }
}
