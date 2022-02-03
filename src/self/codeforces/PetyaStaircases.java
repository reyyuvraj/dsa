package self.codeforces;

import java.util.*;

public class PetyaStaircases {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] dirty = new int[m];

        for (int i = 0; i < m; i++) {
            dirty[i] = in.nextInt();
        }

        Arrays.sort(dirty);

        if (dirty.length == 0) {
            System.out.println("YES");
            return;
        }

        if (dirty[0] == 1 || dirty[m - 1] == n) {
            System.out.println("NO");
            return;
        }

        if (dirty.length < 3) {
            System.out.println("YES");
            return;
        } else {
            for (int i = dirty.length - 1; i >= 2; i--) {
                if (climbing(dirty, i) && climbing(dirty, i - 1)) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");

    }

    private static boolean climbing(int[] staircases, int i) {
        return staircases[i] - staircases[i - 1] == 1;
    }
}