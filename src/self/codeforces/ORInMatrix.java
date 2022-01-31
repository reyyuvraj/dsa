package self.codeforces;

import java.util.*;

public class ORInMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] matrixB = new int[m][n];
        int[][] matrixA = new int[m][n];
        int f = 0, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixB[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixB[i][j] == 1) {
                    f++;
                    if (!(rowCheck(matrixB, i, j, m, n) || columnCheck(matrixB, i, j, m, n))) {
                        System.out.println("NO");
                        return;
                    }
                    if (rowCheck(matrixB, i, j, m, n) && columnCheck(matrixB, i, j, m, n)) {
                        matrixA[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixA[i][j] == 0)
                    count++;
            }
        }

        if (count==m*n){
            if (Arrays.deepEquals(matrixA, matrixB)){
                System.out.println("YES");
                printMatrix(matrixA, m, n);
            } else {
                System.out.println("NO");
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixA[i][j] == 1) {
                    if (!(rowCheck(matrixB, i, j, m, n) && columnCheck(matrixB, i, j, m, n))) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");
        printMatrix(matrixA, m, n);
    }

    private static boolean rowCheck(int[][] arr, int i, int j, int m, int n) {
        for (j = 0; j < n; j++)
            if (arr[i][j] != 1) {
                return false;
            }
        return true;
    }

    private static boolean columnCheck(int[][] arr, int i, int j, int m, int n) {
        for (i = 0; i < m; i++) {
            if (arr[i][j] != 1)
                return false;
        }
        return true;
    }

    private static void printMatrix(int[][] arr, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}