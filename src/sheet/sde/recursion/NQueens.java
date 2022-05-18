package sheet.sde.recursion;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();

        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    private boolean validate(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        col = dupCol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;

        }

        return true;
    }

    private void dfs(int col, char[][] board, List<List<String>> res){
        if (col== board.length){
            res.add(construct(board));
            return;
        }

        for (int row=0;row< board.length;row++){
            if (validate(board, row, col)){
                board[row][col]='Q';
                dfs(col+1, board, res);
                board[row][col]='.';
            }
        }
    }
}
