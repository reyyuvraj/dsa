package college;

import java.util.Arrays;
import java.util.Scanner;
// Yuvraj Singh CS-6B (63) 1900290120134
public class Parity {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int[] row = new int[m];
        int[] column = new int[n];

        parity(arr, row, column);

        System.out.println(Arrays.toString(row) + "\n" + Arrays.toString(column) + "\n");

        for (int i = 0; i < m; i++) {
            arr[i][0] = (arr[i][0] == 0) ? 1 : 0;
        }

        parity(arr, row, column);

        System.out.println(Arrays.toString(row) + "\n" + Arrays.toString(column));
    }

    public static void parity(int[][] arr, int[] row, int[] column) {
        int m = arr.length, n = arr[0].length;
        for (int i = 0; i < m; i++) {
            int r = arr[i][0];
            for (int j = 1; j < n; j++) {
                r ^= arr[i][j];
            }
            row[i] = r;
        }

        for (int j = 0; j < n; j++) {
            int c = arr[0][j];
            for (int i = 1; i < m; i++) {
                c ^= arr[i][j];
            }
            column[j] = c;
        }
    }
}