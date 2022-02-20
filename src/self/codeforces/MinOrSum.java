package self.codeforces;

import java.util.*;

public class MinOrSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            System.out.println(minSum(a, n));
            t--;
        }
    }

    private static int minSum(int[] a, int n) {
        int sum = 0;

        for (int i = 1; i < n; i++) {
            int k = a[i] | a[i - 1];
            sum = k | sum;
        }

        return sum;
    }
}
