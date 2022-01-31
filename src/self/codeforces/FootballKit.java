package self.codeforces;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] color = new int[n][2];
        int[][] worn = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                color[i][j] = in.nextInt();
                if (j == 0)
                    worn[i][j] = n - 1;
            }
        }

        int matches = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            int home = color[i][0];
            for (int k = 0; k < n; k++) {
                if (k == i)
                    continue;
                if (home == color[k][1])
                    worn[k][0] += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int w = worn[i][0];
            System.out.println(w + " " + (matches - 1 - w));
        }
    }
}