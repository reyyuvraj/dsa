package self.codeforces;

import java.util.*;

public class GeorgeAndRound {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];
        int i = 0, j = 0, res = 0;

        for (i = 0; i < a.length; i++)
            a[i] = in.nextInt();

        for (i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        for (i = 0; i < n; i++) {
            while (j < m) {
                if (b[j] >= a[i]) {
                    res++;
                    i++;
                }
                j++;
            }
        }
        System.out.println(Math.max(res, n - res));
    }
}