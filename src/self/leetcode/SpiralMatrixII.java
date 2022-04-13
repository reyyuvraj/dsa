package self.leetcode;

import java.util.Arrays;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int value = 1, i = 0;

        while (value <= n * n) {
            int j = i;
            while (j < n - i)
                res[i][j++] = value++;
            j = i + 1;
            while (j < n - i)
                res[j++][n - i - 1] = value++;
            j = n - i - 2;
            while (j > i)
                res[n - i - 1][j--] = value++;
            j = n - i - 1;
            while (j > i)
                res[j--][i] = value++;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(n)));
    }
}
