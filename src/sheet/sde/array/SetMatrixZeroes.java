package sheet.sde.array;


import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZeroes {

    private static void convertToZero(int[][] arr, int m, int n, HashSet<Integer> row, HashSet<Integer> col) {

        int rows = 0, cols = 0;

        for (int j : col) {
            cols = j;
            for (int i = 0; i < m; i++)
                arr[i][cols] = 0;
        }

        for (int j : row) {
            rows = j;
            for (int i = 0; i < n; i++)
                arr[rows][i] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        int m = arr.length, n = arr[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        System.out.println(Arrays.toString(row.toArray()) + "\n" + Arrays.toString(col.toArray()));

        convertToZero(arr, m, n, row, col);
        System.out.println(Arrays.deepToString(arr));
    }
}