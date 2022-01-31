package self.codeforces;

import java.util.*;

public class LittleMagicSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] square = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                square[i][j] = in.nextInt();
            }
        }

        int a = square[0][1] + square[0][2], b = square[1][0] + square[1][2], c = square[2][0] + square[2][1];

        int sum = (a + b + c) / 2;

        square[0][0] = sum - a;
        square[1][1] = sum - b;
        square[2][2] = sum - c;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(square[i][j]+" ");
            }
            System.out.println();
        }
    }
}
