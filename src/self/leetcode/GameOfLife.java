package self.leetcode;

import java.util.Arrays;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int alive = count(i - 1, j - 1, board, row, col) +
                        count(i - 1, j, board, row, col) +
                        count(i - 1, j + 1, board, row, col) +
                        count(i, j - 1, board, row, col) +
                        count(i, j + 1, board, row, col) +
                        count(i + 1, j - 1, board, row, col) +
                        count(i + 1, j, board, row, col) +
                        count(i + 1, j + 1, board, row, col);

                if (board[i][j] == 1) {
                    if (alive < 2)
                        res[i][j] = 0;
                    else if (alive == 2 || alive == 3)
                        res[i][j] = 1;
                    else
                        res[i][j] = 0;
                }

                if (board[i][j] == 0) {
                    if (alive == 3)
                        res[i][j] = 1;
                }
            }
        }

        //System.arraycopy(res, 0, board, 0, row);
        //cloning is faster than arraycopy
        for (int i = 0; i < row; i++) {
            board[i] = res[i].clone();
        }
    }

    private static int count(int i, int j, int[][] board, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == 0) return 0;
        return 1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
