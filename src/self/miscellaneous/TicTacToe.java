package self.miscellaneous;

public class TicTacToe {

    static boolean horizontal(int[][] moves, char ch, int r){
        return moves[r][0] == ch && moves[r][1] == ch && moves[r][2] == ch;
    }

    static boolean vertical(int[][] moves, char ch, int c){
        return moves[0][c] == ch && moves[1][c] == ch && moves[2][c] == ch;
    }

    static boolean diagonal(int[][] moves, char ch){
        return (moves[0][0]==ch && moves[1][1]==ch && moves[2][2]==ch) ||
                (moves[0][2]==ch && moves[1][1]==ch && moves[2][0]==ch);
    }

    static String tictactoe(int[][] moves) {
        String str = "";
        boolean result=false;
        if (moves.length==9){

            if (!result)
                str="Draw";
            else
                str="A";
        } else {
            if (result){
                str = (moves.length%2==0)? "B":"A";
            } else
                str = "Pending";
        }
        return str;
    }

    public static void main(String[] args){
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        System.out.println(tictactoe(moves));
    }
}