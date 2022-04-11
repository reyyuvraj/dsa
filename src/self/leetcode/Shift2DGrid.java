package self.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift2DGrid {

    private void shift(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int last = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i>0){
                    if (j != 0)
                        grid[i][j] = grid[i][j - 1];
                    else
                        grid[i][j] = grid[i-1][n-1];
                } else {
                    if (j != 0)
                        grid[i][j] = grid[i][j - 1];
                    else
                        grid[i][j] = last;
                }
            }
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i=1;i<=k;i++){
            shift(grid);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int[] ints : grid) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(ints[j]);
            }
            res.add(row);
        }

        return res;
    }

    public List<List<Integer>> shiftGridBetter(int[][] grid, int k) {
        int rowCount = grid.length;                         // Number of rows in grid.
        int colCount = grid[0].length;                      // Number of columns in grid.
        int gridCount = rowCount * colCount;                // Number of cells (i.e. values) in grid.
        k = k % gridCount;                                  // Limit k to max number of cells in grid.                                                                Avoid negatives in next lines.
        int kCol = (gridCount - k) % colCount;              // Column to start copying from.
        int kRow = ((gridCount - k) % gridCount) / colCount;// Row to start copying from.
        int[] innRow = grid[kRow];                          // Array for the row to start copying from.
        int[][] result = new int[rowCount][colCount];       // Create result matrix, to hold shifted                                                                  values.
        for (int r = 0; r < rowCount; r++) {                // Loop through "to" rows.
            int[] outRow = result[r];                       // Get row array to copy into, so only                                                                    faster 1D reference in inner loop.
            for (int c = 0; c < colCount; c++) {            // Loop through "to" columns.
                outRow[c] = innRow[kCol];                   // Copy value from grid to result, shifting                                                                by copying.
                if (++kCol >= colCount) {                   // Next "from" column.  If at end of row...
                    kCol = 0;                               // Then start "from" columns at first                                                                      column.
                    if (++kRow >= rowCount)                 // When starting new column, next "from"                                                                  row.  If at end of grid...
                        kRow = 0;                           // Then start "from" rows at first row.
                    innRow = grid[kRow];                    // Get row array to copy from, so only                                                                    faster 1D reference when copying.
                }
            }
        }
        return (List) Arrays.asList(result);                 // Return result matrix, converting it to a                                                                List<List<Integer>>.
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        int k = 4;
        System.out.println(new Shift2DGrid().shiftGrid(grid, k));
    }
}
