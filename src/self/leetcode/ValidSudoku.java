package self.leetcode;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!isValid(board, board[i][j], i, j)) return false;
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

    public static void main(String[] args){
        //char[][] board = //[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]];
    }
}
