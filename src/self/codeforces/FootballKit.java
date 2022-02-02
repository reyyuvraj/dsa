package self.codeforces;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] color_home = new int[n];
        int[] color_away = new int[n];

        int[] count = new int[100001];

        int[] worn_home = new int[n];

        for (int i = 0; i < n; i++) {
            color_home[i] = in.nextInt();
            color_away[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            count[color_home[i] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            worn_home[i] = n - 1;
            worn_home[i] += count[color_away[i]-1];
            System.out.println(worn_home[i] + " " + (2 * (n - 1) - worn_home[i]));
        }

    }
}