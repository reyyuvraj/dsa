package self.leetcode;

public class CheckXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0 || grid[i][n - 1 - i] == 0)
                return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1)
                    continue;
                if (grid[i][j] != 0)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0, 0, 0, 0}, {0, 4, 0, 1, 0}, {0, 0, 5, 0, 0}, {0, 5, 0, 2, 0}, {4, 0, 0, 0, 2}};//[[2,0,0,0,0],[0,4,0,1,0],[0,0,5,0,0],[0,5,0,2,0],[4,0,0,0,2]]
        System.out.println(new CheckXMatrix().checkXMatrix(grid));
    }
}
