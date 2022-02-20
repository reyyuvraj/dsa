package self.codeforces;

import java.util.*;

public class AvoidLocalMaximums {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                min = Math.min(min, a[i]);
            }
            localMaximum(a, n);
            t--;
        }
    }

    private static void localMaximum(int[] a, int n) {
        int counter = 0;

        for (int i = 1; i + 1 < n; i++) {
            if (a[i] > a[i + 1] && a[i] > a[i - 1]) {
                if (i + 2 < n) {
                    a[i + 1] = Math.max(a[i], a[i + 2]);
                } else {
                    a[i + 1] = a[i];
                }
                counter++;
            }
        }

        System.out.println(counter);
        printArray(a);
        System.out.println();
    }

    private static void printArray(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
    }
}
