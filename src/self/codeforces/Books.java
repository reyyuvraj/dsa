package self.codeforces;

import java.util.*;

public class Books {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int max_book = max(a, n, t);

        System.out.println(max_book);

    }

    private static int max(int[] a, int n, int t){
        int r = 0;
        int time = 0;
        int max_books = 0;
        for (int i = 0; i < n; ++i) {
            while (r < n && time + a[r] <= t) {
                time += a[r];
                ++r;
            }
            max_books = Math.max(max_books, r - i);
            time -= a[i];
        }

        return max_books;
    }
}