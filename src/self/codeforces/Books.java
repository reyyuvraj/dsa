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

        int i = 0, j = 0, sum = 0;
        int max_time = 0;
        int max_book = 0;
        while (i < n && j < n) {
            sum+=a[j];
            if (t>=sum){
                max_time = Math.max(max_time, sum);
                max_book = Math.max(max_book, j-i+1);
                j++;
            } else {
                sum = 0;
                i++;
                j=i;
            }
        }
        System.out.println(max_book);

    }
}