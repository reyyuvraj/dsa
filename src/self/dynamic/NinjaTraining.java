package self.dynamic;

import java.util.*;

class Tabulation {

    public int ninjaPoints(int n, int[][] points) {

        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
}

public class NinjaTraining {

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return ninjaPoints(n - 1, 3, points, dp);
    }

    public static int ninjaPoints(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last)
                    max = Math.max(points[day][i], max);
            }
            return dp[day][last] = max;
        }

        int max = 0;

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = points[day][i] + ninjaPoints(day - 1, i, points, dp);
                max = Math.max(activity, max);
            }
        }

        return dp[day][last] = max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = in.nextInt();
            }
        }
        System.out.println(ninjaTraining(n, points));// recursion + memoization

        Tabulation ob = new Tabulation();
        System.out.println(ob.ninjaPoints(n, points));
    }
}
