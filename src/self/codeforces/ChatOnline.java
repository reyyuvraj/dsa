package self.codeforces;

import java.util.*;

public class ChatOnline {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();

        int[][] a = new int[p][2];
        int[][] c = new int[q][2];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = in.nextInt();
            }
        }

        int m = 0;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j <q; j++) {
                int t = l;
                while (t <= r) {
                    if (check(a[i][0], a[i][1], c[j][0], c[j][1], t))
                        m++;
                    t++;
                }
            }
        }
        System.out.println(m);
    }

    private static boolean check(int a, int b, int c, int d, int t) {
        return a == c + t || a == d + t || b == c + t || b == d + t;
    }
}
