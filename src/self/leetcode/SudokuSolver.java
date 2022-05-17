package self.leetcode;

public class SudokuSolver {

    private boolean solve(char[][] board){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]=='.'){
                    for (char c='1';c<='9';c++){
                        if (isValid(board, c, i, j)){
                            board[i][j]=c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, char c, int row, int col){
        for (int i=0;i<9;i++){
            if (board[row][i]==c) return false;
            if (board[i][col]==c) return false;
            if (board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
        return true;
    }
}
