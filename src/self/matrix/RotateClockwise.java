package self.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class RotateClockwise {

    static void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
        print(matrix);
    }

    static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    static void print(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] printMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = matrix[i][j];
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Scanner xx = new Scanner(System.in);
        int n = xx.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = xx.nextInt();
            }
        }
        rotate(matrix);
        System.out.println();
        System.out.println(Arrays.deepToString(printMatrix(matrix)));
    }
}